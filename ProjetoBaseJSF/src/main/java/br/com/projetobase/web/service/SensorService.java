package br.com.projetobase.web.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.projetobase.arq.dao.hibernate.interceptor.transaction.Transactional;
import br.com.projetobase.dao.SensorDAO;
import br.com.projetobase.modelo.Sensor;

public class SensorService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SensorDAO sensorDAO;

	@Transactional
	public void salvar(Sensor sensor) {
		
		if (sensor.getId() != null && sensor.getId() != 0) {
			sensorDAO.inserir(sensor);
		} else {
			sensorDAO.atualizar(sensor);
		}
	}
	
	@Transactional
	public void atualizarLista(List<Sensor> sensores) {
		
		for(Sensor sensor: sensores){
			if(sensor.isEditable()){
				sensor.setEditable(false);
				sensorDAO.atualizar(sensor);
			}
			
			
		}
		
	}
	
	@Transactional
	public void deletar(Sensor sensor){
		
		if (sensor.getId() != null && sensor.getId() != 0){
			
			sensorDAO.remover(sensor);
			
		}
		
	}
	

	
}
