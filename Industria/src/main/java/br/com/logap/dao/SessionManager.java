package br.com.logap.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionManager {
	
	private static SessionManager sessionManager;
	private static SessionFactory sessionFactory;
	private static Configuration configuration;
	
	
	private SessionManager(){
		configuration = new Configuration().configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		
	}
	
	public static SessionManager getInstancia() {
		
		if(sessionManager == null){
			sessionManager = new SessionManager();
		}
		
		return sessionManager;
		
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
	
	
	
	

	
	

	
}
