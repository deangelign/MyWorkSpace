package br.com.logap.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.logap.modelo.Usuario;

public class UsuarioDAO extends HibernateDAO<Usuario> {

	public UsuarioDAO(){
		super();
	}
	
	public String acharPorLogin(String login){
		//login ="bbbb";
		SessionManager sessionManager = SessionManager.getInstancia();
		List<Usuario> usuarios = new ArrayList();
		Session session = sessionManager.getSession();
		Query q = session.createQuery("from Usuario where login=:login");
		q.setString("login", login);
		if(q!=null){
			usuarios = q.list();		
			System.out.println("senha " +usuarios.get(0).getSenha());
			session.close();
			return usuarios.get(0).getSenha();
		}
		return "";
	}
	
}
