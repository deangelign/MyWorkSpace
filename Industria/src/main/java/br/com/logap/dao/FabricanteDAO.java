package br.com.logap.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.logap.modelo.Fabricante;

public class FabricanteDAO extends DAO{
	
	public FabricanteDAO (){
		super();		
	}
	
	public void inserir(Fabricante fabricante){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(fabricante);
		transaction.commit();
		session.close();
	}
		
	public void deletar(Fabricante fabricante){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(fabricante);
		transaction.commit();
		session.close();
	}
	
	public void Modificar(Fabricante fabricante){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(fabricante);
		transaction.commit();
		session.close();
	}
	
	public List<Fabricante> buscarTodos(){
		String HQL = "From Fabricante";
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		List<Fabricante>fabricantes = query.list();
		return fabricantes;
		
	}
	
	public Fabricante buscarPorID(long fabricanteID){
		String HQL = "From Fabricante v where v.id = :fabricante_id";
		
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		query.setLong("fabricante_id", fabricanteID);
		
		return (Fabricante) query.uniqueResult();		
	}

}