package br.com.projetobase.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetobase.arq.util.DadosSessao;
import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.web.service.EquipamentoService;

@Named
@RequestScoped
public class CadastroEquipamentoBean extends AbstractBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private Equipamento equipamento;

	@Inject
	private EquipamentoService equipamentoService;

	@Inject
	private DadosSessao dadosSessao;

	
	public void cadastrar() {
		equipamento.setUsuario(dadosSessao.getUsuario());
		equipamentoService.salvar(equipamento);

	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	

	

}
