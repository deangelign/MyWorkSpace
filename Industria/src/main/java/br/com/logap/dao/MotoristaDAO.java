package br.com.logap.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.logap.modelo.Motorista;

public class MotoristaDAO extends DAO{

	public MotoristaDAO(){
		super();		
	}
			
	public void inserir(Motorista motorista){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(motorista);
		transaction.commit();
		session.close();
	}
		
	public void deletar(Motorista motorista){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(motorista);
		transaction.commit();
		session.close();
	}
	
	public void Modificar(Motorista motorista){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(motorista);
		transaction.commit();
		session.close();
	}
	
	public List<Motorista> buscarTodos(){
		
		String HQL = "From motorista";
		Session session = SessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		List<Motorista>motoristaes = query.list();
		return motoristaes;
		
	}
	
	public Motorista buscarPorID(long motoristaID){
		String HQL = "From motorista v where v.id = :motorista_id";
		
		Session session = SessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		query.setLong("motorista_id", motoristaID);
		
		return (Motorista) query.uniqueResult();		
	}
	
	
}
