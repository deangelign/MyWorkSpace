package br.com.logap.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.logap.modelo.TipoProduto;

public class TipoProdutoDAO extends DAO{
	public TipoProdutoDAO(){
		super();
	}
	public void inserir(TipoProduto tipoProduto){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(tipoProduto);
		transaction.commit();
		session.close();		
	}
	
	public void deletar(TipoProduto tipoProduto){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(tipoProduto);
		transaction.commit();
		session.close();
	}
	
	public void Modificar(TipoProduto tipoProduto){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(tipoProduto);
		transaction.commit();
		session.close();
	}
	
	public List<TipoProduto> buscarTodos(){
		String HQL = "From TipoProduto";
		Session session = SessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		List<TipoProduto>tipoProduto = query.list();
		return tipoProduto;
	}
	
	public TipoProduto buscarPorID(long tipoProdutoID){
		String HQL = "From TipoProduto v where v.id = :tipoProduto_id";
		Session session = SessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		query.setLong("tipoProduto_id", tipoProdutoID);
		
		return (TipoProduto) query.uniqueResult();		
	}

}
