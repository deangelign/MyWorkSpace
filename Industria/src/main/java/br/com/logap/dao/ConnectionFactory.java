package br.com.logap.dao;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ConnectionFactory {
	
	private SessionFactory sessionFactory;
	
	public ConnectionFactory(){
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	public SessionFactory getInstancia() {
		
		if(this.sessionFactory == null){
			ConnectionFactory();	
		}
		return this.sessionFactory;
		
	}

	private void ConnectionFactory() {
		// TODO Auto-generated method stub
		
	}

	
}
