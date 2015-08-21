package br.com.logap.servicoHistorico.all;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class GeradorDadosHistoricos {

	private static MyDatasource dataSource;
	private final static Logger loggerMain = Logger.getLogger(GeradorDadosHistoricos.class);

	public GeradorDadosHistoricos() throws IOException, SQLException, PropertyVetoException {
		dataSource = MyDatasource.getInstance();
	}

	public static void main(String args[]) throws SQLException {
		loggerMain.info("criando tabela no banco......");
		//criarTabelaNoBanco();
		loggerMain.info("tabela criada");

		 ThreadSensorManager treSensorManager = new ThreadSensorManager();
		 ScheduledThreadPoolExecutor scheduledThread = new ScheduledThreadPoolExecutor(50);
		 scheduledThread.scheduleWithFixedDelay(treSensorManager, 0, 120, TimeUnit.SECONDS);

	}

	public static void criarTabelaNoBanco() throws SQLException {
		String sql = "create table IF NOT EXISTS historico (id SERIAL, valor DOUBLE PRECISION,"
				+ "tempo TIMESTAMP, id_sensor BIGINT, PRIMARY KEY (id) );";

		PreparedStatement stmt = null;
		try {
			dataSource = MyDatasource.getInstance();
			Connection con = dataSource.getConnection();
			
			stmt = con.prepareStatement(sql);
			stmt.close();
			con.close();
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			
		}
	}

}
