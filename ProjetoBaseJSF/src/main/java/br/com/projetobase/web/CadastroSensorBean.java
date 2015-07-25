package br.com.projetobase.web;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetobase.arq.util.DadosSessao;
import br.com.projetobase.dao.hibernate.EquipamentoHibernateDAO;
import br.com.projetobase.modelo.Equipamento;

@Named
@ViewScoped
public class CadastroSensorBean extends AbstractBean{

	private static final long serialVersionUID = 1L;
	
	private Equipamento equipamento;

	private List<Equipamento> equipamentos;
	
	public CadastroSensorBean() {
	}
	
	@Inject
	public CadastroSensorBean(EquipamentoHibernateDAO equipamentoHibernateDAO, DadosSessao dadosSessao) {
		this.equipamentos = equipamentoHibernateDAO.buscarEquipamentosUsuario(dadosSessao.getUsuario().getId());
		equipamento = new Equipamento();
	}
	
	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	
	
	
	
	
}