package br.com.projetobase.web.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.projetobase.arq.dao.hibernate.interceptor.transaction.Transactional;
import br.com.projetobase.dao.EquipamentoDAO;
import br.com.projetobase.dao.hibernate.SensorHibernateDAO;
import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.modelo.Sensor;


public class EquipamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EquipamentoDAO equipamentoDAO;

	@Transactional
	public void salvar(Equipamento equipamento) {

		if (equipamento.getId() != null && equipamento.getId() != 0) {
			equipamentoDAO.inserir(equipamento);
		} else {
			equipamentoDAO.atualizar(equipamento);
		}
	}

	@Transactional
	public void deletar(Equipamento equipamento, SensorHibernateDAO sensorHibernateDAO, SensorService sensorService) {

		if (equipamento.getId() != null && equipamento.getId() != 0) {
			equipamentoDAO.remover(equipamento);
		}

	}

	@Transactional
	public void atualizarLista(List<Equipamento> equipamentos) {

		for (Equipamento equipamento : equipamentos) {
			if (equipamento.isEditable()) {
				equipamento.setEditable(false);
				equipamentoDAO.atualizar(equipamento);
			}

		}

	}

}
