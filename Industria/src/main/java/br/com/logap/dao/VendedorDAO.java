package br.com.logap.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.logap.modelo.Venda;

public class VendedorDAO{
	
	
	
	
	public void inserir(Venda venda, SessionManager sessionManager){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(venda);
		transaction.commit();
		session.close();
	} 
	
	
	
	public void deletar(Venda venda, SessionManager sessionManager){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(venda);
		transaction.commit();
		session.close();
	}
	
	public void Modificar(Venda venda, SessionManager sessionManager){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(venda);
		transaction.commit();
		session.close();
	}
	
	
	public void buscarTodos(SessionManager sessionManager){
		
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		
		
	}

	
	
	
}
