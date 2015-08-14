package br.com.logap.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.logap.modelo.Cliente;

public class ClienteDAO extends DAO{
	
	public ClienteDAO(){
		super();
	}
	public void inserir(Cliente cliente){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(cliente);
		transaction.commit();
		session.close();		
	}
	
	public void deletar(Cliente cliente){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(cliente);
		transaction.commit();
		session.close();
	}
	
	public void Modificar(Cliente cliente){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(cliente);
		transaction.commit();
		session.close();
	}
	
	public List<Cliente> buscarTodos(){
		String HQL = "From Cliente";
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		List<Cliente>clientes = query.list();
		return clientes;
	}
	
	public Cliente buscarPorID(long clienteID){
		String HQL = "From Cliente v where v.id = :cliente_id";
		
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		query.setLong("cliente_id", clienteID);
		
		return (Cliente) query.uniqueResult();		
	}
}