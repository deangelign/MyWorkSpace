package br.com.logap.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.logap.modelo.Almoxarifado;
import br.com.logap.modelo.Cliente;

public class AlmoxarifadoDAO extends DAO{
		
	public AlmoxarifadoDAO(){
		super();
	}


	public void inserir(Almoxarifado almoxarifado){
	Session session = sessionManager.getSession();
	Transaction transaction = session.beginTransaction();
	session.saveOrUpdate(almoxarifado);
	transaction.commit();
	session.close();	
	}
	public void deletar(Almoxarifado almoxarifado){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(almoxarifado);
		transaction.commit();
		session.close();
	}
	public void Modificar(Almoxarifado almoxarifado){
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(almoxarifado);
		transaction.commit();
		session.close();
	}
	public List<Almoxarifado> buscarTodos(){
		String HQL = "From Almoxarifado";
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		List<Almoxarifado>almoxarifados = query.list();
		return almoxarifados;
	}
	public Almoxarifado buscarPorID(long almoxarifadoID){
		String HQL = "From Almoxarifado v where v.id = :almoxarifado_id";
		
		Session session = sessionManager.getSession();
		Query query = (Query) session.createQuery(HQL);
		query.setLong("almoxarifado_id", almoxarifadoID);
		
		return (Almoxarifado) query.uniqueResult();		
	}
}