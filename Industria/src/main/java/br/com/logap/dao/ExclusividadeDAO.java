package br.com.logap.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.logap.modelo.Exclusividade;

public class ExclusividadeDAO extends DAO{

	
	public ExclusividadeDAO(){
		super();		
	}
			
	public void inserir(Exclusividade exclusividade){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(exclusividade);
		transaction.commit();
		session.close();
	}
		
	public void deletar(Exclusividade exclusividade){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(exclusividade);
		transaction.commit();
		session.close();
	}
	
	public void Modificar(Exclusividade exclusividade){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(exclusividade);
		transaction.commit();
		session.close();
	}
	
	public List<Exclusividade> buscarTodos(){
		
		String HQL = "From exclusividade";
		Session session = SessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		List<Exclusividade>exclusividadees = query.list();
		return exclusividadees;
		
	}
	
	public Exclusividade buscarPorID(long exclusividadeID){
		String HQL = "From exclusividade v where v.id = :exclusividade_id";
		
		Session session = SessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		query.setLong("exclusividade_id", exclusividadeID);
		
		return (Exclusividade) query.uniqueResult();		
	}

	
	
}
