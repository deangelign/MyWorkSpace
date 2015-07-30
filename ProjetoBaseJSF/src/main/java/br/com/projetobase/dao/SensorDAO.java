package br.com.projetobase.dao;

import java.util.List;

import br.com.projetobase.arq.dao.DAO;
import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.modelo.Sensor;

public interface SensorDAO extends DAO<Sensor>{
	
	List<Sensor> buscarSensoresEquipamento(long equipamentoID);
}
