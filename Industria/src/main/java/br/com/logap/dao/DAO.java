package br.com.logap.dao;

import org.hibernate.Session;

public class DAO {
	
	SessionManager sessionManager;
	
	public DAO(){
		sessionManager =  SessionManager.getInstancia();
	}
	
	public Session getSession(){
		return sessionManager.getSession();
	}
	
}
