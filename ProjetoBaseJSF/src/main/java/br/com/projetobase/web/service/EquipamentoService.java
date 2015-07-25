package br.com.projetobase.web.service;

import javax.inject.Inject;

import br.com.projetobase.arq.dao.hibernate.interceptor.transaction.Transactional;
import br.com.projetobase.dao.EquipamentoDAO;
//import br.com.projetobase.dao.EquipamentoDAO;
import br.com.projetobase.modelo.Equipamento;


public class EquipamentoService {

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

}
