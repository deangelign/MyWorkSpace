package br.com.logap.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.logap.modelo.Vendedor;

public class VendedorDAO{
	
	
	
	
	public void inserir(Vendedor vendedor, SessionManager sessionManager){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(vendedor);
		transaction.commit();
		session.close();
	} 
	
	
	
	public void deletar(Vendedor vendedor, SessionManager sessionManager){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(vendedor);
		transaction.commit();
		session.close();
	}
	
	public void Modificar(Vendedor vendedor, SessionManager sessionManager){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(vendedor);
		transaction.commit();
		session.close();
	}
	
	
	public List<Vendedor> buscarTodos(SessionManager sessionManager){
		
		String HQL = "From Vendedor";
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		List<Vendedor>vendedores = query.list();
		return vendedores;
		
	}
	
	
	public Vendedor buscarPorID(SessionManager sessionManager, long vendedorID){
		
		String HQL = "From Vendedor v where v.id = :vendedor_id";
		
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		query.setLong("vendedor_id", vendedorID);
		
		return (Vendedor) query.uniqueResult();		
	}

	
	
	
}
