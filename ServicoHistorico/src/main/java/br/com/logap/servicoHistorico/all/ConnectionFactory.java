package br.com.logap.servicoHistorico.all;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String URL_BANCO = "jdbc:postgresql://localhost/teste";

	public Connection getConnection() {
		try {
			return DriverManager.getConnection(URL_BANCO,
					"postgres", "123");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
