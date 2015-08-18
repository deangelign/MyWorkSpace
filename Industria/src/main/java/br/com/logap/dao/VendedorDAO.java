package br.com.logap.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.logap.modelo.Vendedor;

public class VendedorDAO extends DAO{
	
	public VendedorDAO(){
		super();		
	}
			
	public void inserir(Vendedor vendedor){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(vendedor);
		transaction.commit();
		session.close();
	}
		
	public void deletar(Vendedor vendedor){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(vendedor);
		transaction.commit();
		session.close();
	}
	
	public void Modificar(Vendedor vendedor){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(vendedor);
		transaction.commit();
		session.close();
	}
	
	public List<Vendedor> buscarTodos(){
		String HQL = "From Vendedor";
		Session session = SessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		List<Vendedor>vendedores = query.list();
		return vendedores;
	}
	
	public Vendedor buscarPorID(long vendedorID){
		String HQL = "From Vendedor v where v.id = :vendedor_id";
		
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		query.setLong("vendedor_id", vendedorID);
		
		return (Vendedor) query.uniqueResult();		
	}	
}