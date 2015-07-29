package br.com.projetobase.dao.hibernate;

import java.util.List;

import br.com.projetobase.arq.dao.HibernateDAO;
import br.com.projetobase.dao.EquipamentoDAO;
import br.com.projetobase.dao.SensorDAO;
import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.modelo.Sensor;

public class SensorHibernateDAO extends HibernateDAO<Sensor> implements SensorDAO{

	@Override
	public List<Equipamento> buscarSensoresEquipamento(long equipamentoID) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
