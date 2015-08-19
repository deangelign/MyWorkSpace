package br.com.logap.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;



public abstract class HibernateDAO<T extends ModeloPersistencia> implements DAO<T>{

	//private static SessionManager sessionManager;
	private Session session;
	private Transaction transaction;
	private Class<T> classe;

	public HibernateDAO() {
		//sessionManager = (SessionManager.getInstancia());
		Class<T> clazz = getTypeClass();
		classe = clazz;
	}

	
	public Session getSession() {
		return SessionManager.getSession();
	}


	public void inserir(T objeto) {
		session = SessionManager.getSession();
		transaction = session.beginTransaction();
		session.save(objeto);
		transaction.commit();
		session.close();
	}

	public void remover(T objeto) {
		session = SessionManager.getSession();
		transaction = session.beginTransaction();
		session.delete(objeto);
		transaction.commit();
		session.close();
	}

	public void atualizar(T objeto) {
		session = SessionManager.getSession();
		transaction = session.beginTransaction();
		session.update(objeto);
		transaction.commit();
		session.close();

	}
	
	public T buscar(Long id) {
		return session.get(classe, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos(){
		return session.createCriteria(classe).list();
	}

	@SuppressWarnings("unchecked")
	private Class<T> getTypeClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}


}
