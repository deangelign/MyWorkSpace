package br.com.logap.servicoHistorico.all;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class GerarDadosHistoricos {

	public static void main(String args[]) {

		 final Logger logger;
		
		Connection con = new ConnectionFactory().getConnection();
		criarTabelaNoBanco(con);
		List<Historico> historicos = pegarIdSensores(con);
		inserirNaTabela(con, historicos);
	}

	private static void inserirNaTabela(Connection con,
			List<Historico> historicos) {

		
		String sql;
		
		try {
			PreparedStatement stmt = null;
			sql = "insert into historico "
					+ "(valor,tempo,id_sensor)" + " values (?,?,?)";
			stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			
			for (int i = 0; i < historicos.size(); i++) {
				
				System.out.println(i);
				stmt.setDouble(1, historicos.get(i).getValor());
				stmt.setTimestamp(2, historicos.get(i).getTempo());
				stmt.setLong(3, historicos.get(i).getId_sensor());
				stmt.execute();

			}
			
			if (stmt != null) {
				stmt.close();
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	private static List<Historico> pegarIdSensores(Connection con) {
		String sql = "select id from sensor";
		PreparedStatement stmt = null;
		List<Historico> historicos = new ArrayList<Historico>();
		double var = 1000;

		try {
			stmt = con.prepareStatement(sql);
			ResultSet resultSetSensorIds = stmt.executeQuery();

			while (resultSetSensorIds.next()) {

				Historico historico = new Historico();
				historico.setId_sensor(resultSetSensorIds.getLong("id"));
				historico.setTempo(new java.sql.Timestamp(Calendar
						.getInstance().getTimeInMillis()));
				double valor = Math.random() * var;
				historico.setValor(Math.round(valor * 100) / 100.0);
				historico.setId(null);
				historicos.add(historico);
			}

			return historicos;
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

	private static void criarTabelaNoBanco(Connection con) {
		String sql = "create table IF NOT EXISTS historico (id SERIAL, valor DOUBLE PRECISION,"
				+ "tempo TIMESTAMP, id_sensor BIGINT, PRIMARY KEY (id) );";

		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
