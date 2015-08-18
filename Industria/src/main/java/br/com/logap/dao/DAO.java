package br.com.logap.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class DAO<T extends ModeloPersistencia> {

	private SessionManager sessionManager;
	private Session session;
	private Transaction transaction;
	protected Class<T> classe;

	public DAO() {
		setSessionManager(SessionManager.getInstancia());
		classe = getTypeClass();
	}

	public Session getSession() {
		return SessionManager.getSession();
	}

	public SessionManager getSessionManager() {
		return sessionManager;
	}

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
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
	private Class<T> getTypeClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

}
