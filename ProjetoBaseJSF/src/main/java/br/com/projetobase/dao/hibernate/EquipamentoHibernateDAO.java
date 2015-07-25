package br.com.projetobase.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import br.com.projetobase.arq.dao.HibernateDAO;
import br.com.projetobase.arq.dao.excecoes.DAOException;
import br.com.projetobase.dao.EquipamentoDAO;
import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.modelo.Usuario;

public class EquipamentoHibernateDAO extends HibernateDAO<Equipamento> implements EquipamentoDAO{

	private static final long serialVersionUID = 1L;
	
	@Override
	public boolean cadastrarEquipamento(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Equipamento buscarPorNome(String nome) {
		try {
			String hql = "FROM Equipamento WHERE nome LIKE :nomeEquipamento";
			Query query = getSession().createQuery(hql);
			query.setParameter("nomeEquipamento", nome);
			
			return (Equipamento) query.uniqueResult();
		} catch (Exception hibernateException) {
			throw new DAOException(hibernateException);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipamento> buscarEquipamentosUsuario(long idUsuario) {
		try {
			String hql = "FROM Equipamento WHERE usuario.id = :idUsuario";
			Query query = getSession().createQuery(hql);
			query.setParameter("idUsuario", idUsuario);
			
			return query.list();
		} catch (Exception hibernateException) {
			throw new DAOException(hibernateException);
		}
		
	}

}
