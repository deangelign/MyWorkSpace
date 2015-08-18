package br.com.projetobase.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import br.com.projetobase.arq.dao.HibernateDAO;
import br.com.projetobase.arq.dao.excecoes.DAOException;
import br.com.projetobase.dao.UsuarioDAO;
import br.com.projetobase.modelo.Usuario;

public class UsuarioHibernateDAO extends HibernateDAO<Usuario> implements UsuarioDAO {

	private static final long serialVersionUID = 1L;

	@Override
	public Usuario buscarPorEmail(String email) {
		try {
			String hql = "FROM Usuario WHERE email LIKE :emailUsuario";
			System.out.println("11111111111");
			Query query = getSession().createQuery(hql);
			System.out.println("2222222222");
			query.setParameter("emailUsuario", email);
			System.out.println("33333333333");
			
			return (Usuario) query.uniqueResult();
		} catch (Exception hibernateException) {
			throw new DAOException(hibernateException);
		}
	}
	
	public boolean cadastrarUsuario(Usuario usuario){
		
		
		return true;
	}

	@Override
	public List<Usuario> buscarTodosUsuarios() {
		try {
			String hql = "FROM Usuario";
			Query query = getSession().createQuery(hql);
			
			return (List<Usuario>) query.list();
		} catch (Exception hibernateException) {
			throw new DAOException(hibernateException);
		}

	}

}
