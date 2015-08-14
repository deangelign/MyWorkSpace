package br.com.logap.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.logap.modelo.Veiculo;

public class VeiculoDAO extends DAO{
	
	public VeiculoDAO(){
		super();		
	}
	
	public void inserir(Veiculo veiculo){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(veiculo);
		transaction.commit();
		session.close();
	}
		
	public void deletar(Veiculo veiculo){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(veiculo);
		transaction.commit();
		session.close();
	}
	
	public void Modificar(Veiculo veiculo){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(veiculo);
		transaction.commit();
		session.close();
	}
	
	public List<Veiculo> buscarTodos(){
		String HQL = "From Veiculo";
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		List<Veiculo>Veiculos = query.list();
		return Veiculos;
	}
	
	public Veiculo buscarPorID(long veiculoID){
		String HQL = "From Veiculo v where v.id = :Veiculo_id";
		
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		query.setLong("veiculo_id", veiculoID);
		
		return (Veiculo) query.uniqueResult();		
	}
}