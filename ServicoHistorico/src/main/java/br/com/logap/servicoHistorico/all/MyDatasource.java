package br.com.logap.servicoHistorico.all;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyDatasource {

	private ComboPooledDataSource cpds;
	private static MyDatasource datasource;

	private MyDatasource() throws IOException, SQLException, PropertyVetoException {
		cpds = new ComboPooledDataSource();
		cpds.setDriverClass("org.postgresql.Driver"); 
		cpds.setJdbcUrl("jdbc:postgresql://localhost/teste");
		cpds.setUser("postgres");
		cpds.setPassword("123");
		
		cpds.setInitialPoolSize(10);
		cpds.setAcquireIncrement(5);
		cpds.setMinPoolSize(10);
		cpds.setMaxPoolSize(50);
		cpds.setMaxStatements(200);

	}

	public static MyDatasource getInstance() throws IOException, SQLException, PropertyVetoException {
		if (datasource == null) {
			datasource = new MyDatasource();
			return datasource;
		} else {
			return datasource;
		}
	}

	public Connection getConnection() throws SQLException {
		return this.cpds.getConnection();
	}
}
