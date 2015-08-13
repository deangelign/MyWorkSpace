package br.com.projetobase.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import br.com.projetobase.arq.dao.HibernateDAO;
import br.com.projetobase.dao.HistoricoDAO;
import br.com.projetobase.modelo.Historico;

public class HistoricoHibernateDAO extends HibernateDAO<Historico> implements HistoricoDAO{

	private static final long serialVersionUID = 1L;
	
	@Override
	public List<Historico> buscarHistoricoDoGrafico(Long idSensor,
			String dataInicial, String dataFinal) {
		
		String hql = "FROM historico WHERE email sensor.id = idSensor and historico.tempo BETWEEN :startDate and :endDate";
		Query query = getSession().createQuery(hql);
		query.setParameter("startDate", dataInicial);
		query.setParameter("endDate", dataFinal);
		return (List<Historico>) query.list();
		
	}
	
	



	
	
}
