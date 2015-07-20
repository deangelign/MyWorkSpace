package br.com.projetobase.dao.hibernate;

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
			Query query = getSession().createQuery(hql);
			query.setParameter("emailUsuario", email);
			
			return (Usuario) query.uniqueResult();
		} catch (Exception hibernateException) {
			throw new DAOException(hibernateException);
		}
	}
	
	public boolean cadastrarUsuario(Usuario usuario){
		
		
		return true;
	}

}
