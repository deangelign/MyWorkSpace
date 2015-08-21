package br.com.logap.servicoHistorico.all;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class ThreadSensorManager implements Runnable{

	private  final static Logger loggerSensorReveiver = Logger.getLogger(ThreadSensorManager.class);

	MyDatasource dataSource;
	private  List<Long> sensoresID;
	Map<Long, Long> mapSensores;
	ScheduledThreadPoolExecutor scheduledThread;
	
	public ThreadSensorManager() {
		sensoresID = new ArrayList<Long>();
		mapSensores = new HashMap<Long, Long>();
		scheduledThread = new ScheduledThreadPoolExecutor(50);
		try {
			dataSource = MyDatasource.getInstance();
		} catch (IOException | SQLException | PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		loggerSensorReveiver.info("Consultando id dos sensores......");
		sensoresID = pegarIdSensores();
		loggerSensorReveiver.info("Consulta realizada com sucesso");
		
		
		for(Long idSensor: sensoresID){
			loggerSensorReveiver.info("Checando se o sensor de id: " + idSensor + " ja possui thread");
			if(!mapSensores.containsKey(idSensor)){
				loggerSensorReveiver.info("sensor de id: " + idSensor + " nao possui thread. Creando uma thread....");
				mapSensores.put(idSensor, idSensor);
				SensorThread sensorThread = new SensorThread(idSensor);
				scheduledThread.scheduleWithFixedDelay(sensorThread, 0, 30, TimeUnit.SECONDS);
				loggerSensorReveiver.info("thread criada com sucesso");
			}
		}
	}

	
	public List<Long> pegarIdSensores() {
		String sql = "select id from sensor";
		PreparedStatement stmt = null;
		
		try {
			Connection con = dataSource.getConnection();
			stmt = con.prepareStatement(sql);
			ResultSet resultSetSensorIds = stmt.executeQuery();

			while (resultSetSensorIds.next()) {				
				sensoresID.add(resultSetSensorIds.getLong("id"));
			}
			return sensoresID;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
	
}
