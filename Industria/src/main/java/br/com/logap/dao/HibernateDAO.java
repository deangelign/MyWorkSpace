package br.com.logap.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class HibernateDAO<T extends ModeloPersistencia> implements
		DAO<T> {

	private static SessionManager sessionManager;
	private Session session;
	private Transaction transaction;
	private Class<T> classe;

	public HibernateDAO() {
		sessionManager = (SessionManager.getInstancia());
		Class<T> clazz = getTypeClass();
		classe = clazz;
	}

	public Session getSession() {
		return SessionManager.getSession();
	}

	public void inserir(T objeto) {
		session = sessionManager.getSession();
		transaction = session.beginTransaction();
		session.save(objeto);
		transaction.commit();
		session.close();
	}

	public void remover(T objeto) {
		session = sessionManager.getSession();
		transaction = session.beginTransaction();
		session.delete(objeto);
		transaction.commit();
		session.close();
	}

	public void atualizar(T objeto) {
		session = sessionManager.getSession();
		transaction = session.beginTransaction();
		session.update(objeto);
		transaction.commit();
		session.close();

	}


	public T buscar(Long id) {
		session = sessionManager.getSession();
		T obj = session.get(classe, id);
		session.close();
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List<T> buscarTodos() {
		session = sessionManager.getSession();
		List<T> myList = session.createCriteria(classe).list();
		session.close();
		return myList;
	}

	@SuppressWarnings("unchecked")
	private Class<T> getTypeClass() {
		return (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	

}
