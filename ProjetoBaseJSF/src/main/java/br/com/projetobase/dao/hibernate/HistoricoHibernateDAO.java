package br.com.projetobase.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import br.com.projetobase.arq.dao.HibernateDAO;
import br.com.projetobase.dao.HistoricoDAO;
import br.com.projetobase.modelo.Historico;

public class HistoricoHibernateDAO extends HibernateDAO<Historico> implements HistoricoDAO{

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Historico> buscarHistoricoDoGrafico(Long idSensor, Date dataInicial, Date dataFinal) {
		
		//String hql = "FROM Historico";
		String hql = "FROM Historico";
		Query query = getSession().createQuery(hql);
		//System.out.println("id Sensor: " + idSensor);
		//query.setParameter("idSensor", idSensor);
		//query.setParameter("startDate", dataInicial);
		//query.setParameter("endDate", dataFinal);
		return (List<Historico>) query.list();
		
	}
	
	



	
	
}
