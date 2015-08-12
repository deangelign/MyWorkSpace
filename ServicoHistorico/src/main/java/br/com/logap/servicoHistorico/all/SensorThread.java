package br.com.logap.servicoHistorico.all;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.apache.log4j.Logger;

public class SensorThread implements Runnable {

	private  final static Logger loggerSensor = Logger.getLogger(SensorThread.class);
	private long id;
	private Historico historicoAtual;
	MyDatasource ds;

	public SensorThread(long _id) {
		this.id = _id;
		historicoAtual = new Historico();
		historicoAtual.setId_sensor(id);
		historicoAtual.setId(null);

		try {
			ds = MyDatasource.getInstance();
		} catch (IOException | SQLException | PropertyVetoException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		loggerSensor.info("Atualizando o sensor de id: " + id + "......");
		atualizarHistorico();
		loggerSensor.info("sensor de id: " + id + " foi atualizado");
		
		loggerSensor.info("salvando na tabela historico as informacoes do sensor de id: " + id + "......");
		salvarHistorico();
		loggerSensor.info("dados do sensor: " + id + " foi salvo com sucesso");
	}

	public void salvarHistorico() {
		String sql;
		try {
			ds = MyDatasource.getInstance();
			Connection con = ds.getConnection();
			PreparedStatement stmt = null;
			sql = "insert into historico (valor,tempo,id_sensor) values (?,?,?)";
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setDouble(1, historicoAtual.getValor());
			stmt.setTimestamp(2, historicoAtual.getTempo());
			stmt.setLong(3, historicoAtual.getId_sensor());
			stmt.execute();

			if (stmt != null) {
				stmt.close();
			}
			if(con != null){
				con.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
		}

	}

	public void atualizarHistorico() {
		double var = 1000;
		double valor = Math.random() * var;
		historicoAtual.setTempo(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		historicoAtual.setValor(Math.round(valor * 100) / 100.0);
	}

}
