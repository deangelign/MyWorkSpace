package br.com.projetobase.web;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetobase.arq.util.DadosSessao;
import br.com.projetobase.dao.EquipamentoDAO;
import br.com.projetobase.dao.hibernate.SensorHibernateDAO;
import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.modelo.Sensor;
import br.com.projetobase.web.service.EquipamentoService;
import br.com.projetobase.web.service.SensorService;

@Named
@javax.faces.view.ViewScoped
public class CadastroEquipamentoBean extends AbstractBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private Equipamento equipamento;

	private List<Equipamento> equipamentos;
	
	@Inject
	private EquipamentoService equipamentoService;

	@Inject
	private DadosSessao dadosSessao;
	
	@Inject
	private EquipamentoDAO equipamentoDAO;

	@Inject
	private SensorService sensorService;
	
	@Inject
	private SensorHibernateDAO sensorHibernateDAO;
	
	public void cadastrar() {
		equipamento.setUsuario(dadosSessao.getUsuario());
		equipamento.setDataCadastro(new Date());
		equipamentoService.salvar(equipamento);
		
		atualizarLista();

	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	public void atualizarLista(){
		
		if (dadosSessao.getUsuario().getId() != null) {
			this.equipamentos = equipamentoDAO.buscarEquipamentosUsuario(dadosSessao.getUsuario().getId());			
		}

	}
	
	public String editAction(Equipamento equipamento){
		equipamento.setEditable(true);
		return null;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}
	
	public String deletarAction(Equipamento equipamento){
		equipamentoService.deletar(equipamento, sensorHibernateDAO, sensorService);
		atualizarLista();
		return null;
	}
	
	public String salvarAlteracoesAction(){
		this.updateEquipamentos();
		atualizarLista();
		return null;
	}
	
	public void updateEquipamentos(){
		equipamentoService.atualizarLista(equipamentos);
	}

	
	

	

}
