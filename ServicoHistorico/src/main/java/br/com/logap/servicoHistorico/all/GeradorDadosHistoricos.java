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

	static Datasource ds;
	private  final static Logger loggerMain = Logger.getLogger(GeradorDadosHistoricos.class);
	
	public GeradorDadosHistoricos() throws IOException, SQLException,
			PropertyVetoException {
		ds = Datasource.getInstance();
	}

	public static void main(String args[]) throws SQLException {
		loggerMain.info("criando tabela no banco......");
		criarTabelaNoBanco();
		loggerMain.info("tabela criada");
		
		
		GeradorDadosHistoricosThread thread = new GeradorDadosHistoricosThread();
		ScheduledThreadPoolExecutor scheduledThread = new ScheduledThreadPoolExecutor(
				50);
		scheduledThread.scheduleWithFixedDelay(thread, 0, 30, TimeUnit.SECONDS);
	}

	public static void criarTabelaNoBanco() throws SQLException {
		Connection con = ds.getConnection();
		String sql = "create table IF NOT EXISTS historico (id SERIAL, valor DOUBLE PRECISION,"
				+ "tempo TIMESTAMP, id_sensor BIGINT, PRIMARY KEY (id) );";

		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
