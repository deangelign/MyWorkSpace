package br.com.projetobase.dao.hibernate;

import br.com.projetobase.arq.dao.HibernateDAO;
import br.com.projetobase.arq.dao.excecoes.DAOException;
import br.com.projetobase.dao.UsuarioDAO;
import br.com.projetobase.modelo.Usuario;

public class UsuarioHibernateDAO extends HibernateDAO<Usuario> implements UsuarioDAO {

	private static final long serialVersionUID = 1L;

	@Override
	public Usuario buscarPorNome(String nome) {
		
		try {
			return (Usuario) this.getSession().get(Usuario.class, nome);
		} catch (Exception hibernateException) {
			throw new DAOException(hibernateException);
		}
	}

}
