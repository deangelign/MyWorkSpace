package br.com.logap.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.logap.modelo.Fornecedor;

public class FornecedorDAO extends DAO{
	
	public FornecedorDAO(){
		super();		
	}
	
	public void inserir(Fornecedor fornecedor){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(fornecedor);
		transaction.commit();
		session.close();		
	}
	
	public void deletar(Fornecedor fornecedor){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(fornecedor);
		transaction.commit();
		session.close();
	}
	
	public void Modificar(Fornecedor fornecedor){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(fornecedor);
		transaction.commit();
		session.close();
	}
	
	public List<Fornecedor> buscarTodos(){
		String HQL = "From Fornecedor";
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		List<Fornecedor>fornecedores = query.list();
		return fornecedores;
	}
	
	public Fornecedor buscarPorID(long fornecedorID){
		String HQL = "From Fornecedor v where v.id = :fornecedor_id";
		
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		query.setLong("fornecedor_id", fornecedorID);
		
		return (Fornecedor) query.uniqueResult();
	}
}