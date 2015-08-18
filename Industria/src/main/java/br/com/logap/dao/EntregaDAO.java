package br.com.logap.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.logap.modelo.Entrega;

public class EntregaDAO extends DAO{
	public EntregaDAO(){
		super();		
	}
			
	public void inserir(Entrega entrega){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(entrega);
		transaction.commit();
		session.close();
	}
		
	public void deletar(Entrega entrega){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(entrega);
		transaction.commit();
		session.close();
	}
	
	public void Modificar(Entrega entrega){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(entrega);
		transaction.commit();
		session.close();
	}
	
	public List<Entrega> buscarTodos(){
		
		String HQL = "From Entrega";
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		List<Entrega>Entregas = query.list();
		return Entregas;
		
	}
	
	public Entrega buscarPorID(long entregaID){
		String HQL = "From Entrega v where v.id = :entrega_id";
		
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		query.setLong("Entrega_id", entregaID);
		
		return (Entrega) query.uniqueResult();		
	}
}
