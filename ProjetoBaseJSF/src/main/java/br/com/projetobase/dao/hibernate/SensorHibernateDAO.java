package br.com.projetobase.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import br.com.projetobase.arq.dao.HibernateDAO;
import br.com.projetobase.arq.dao.excecoes.DAOException;
import br.com.projetobase.dao.EquipamentoDAO;
import br.com.projetobase.dao.SensorDAO;
import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.modelo.Sensor;

public class SensorHibernateDAO extends HibernateDAO<Sensor> implements SensorDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<Sensor> buscarSensoresEquipamento(long equipamentoId) {
		
		try {
			String hql = "FROM Sensor WHERE equipamento.id = :idEquipamento";
			Query query = getSession().createQuery(hql);
			query.setParameter("idEquipamento", equipamentoId);
			return query.list();
		} catch (Exception hibernateException) {
			throw new DAOException(hibernateException);
		}

		
	}
	
}
