package br.com.logap.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.logap.modelo.Produto;

public class ProdutoDAO extends DAO{

	public ProdutoDAO(){
		super();		
	}

	public void inserir(Produto produto){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(produto);
		transaction.commit();
		session.close();
	}

	public void deletar(Produto produto){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();

		session.delete(produto);
		transaction.commit();
		session.close();
	}

	public void Modificar(Produto produto){
		Session session = SessionManager.getSession();
		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(produto);
		transaction.commit();
		session.close();
	}

	public List<Produto> buscarTodos(){
		String HQL = "From Produto";
		Session session = SessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		List<Produto>produtos = query.list();
		return produtos;
	}

	public Produto buscarPorID(long produtoID){
		String HQL = "From Produto v where v.id = :produto_id";

		Session session = SessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		query.setLong("produto_id", produtoID);

		return (Produto) query.uniqueResult();		
	}
}