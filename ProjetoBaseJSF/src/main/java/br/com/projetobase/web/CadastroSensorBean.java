package br.com.projetobase.web;

import java.util.Date;


import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetobase.arq.util.DadosSessao;
import br.com.projetobase.dao.hibernate.EquipamentoHibernateDAO;
import br.com.projetobase.dao.hibernate.SensorHibernateDAO;
import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.modelo.Sensor;
import br.com.projetobase.web.service.SensorService;

@Named
@javax.faces.view.ViewScoped
public class CadastroSensorBean extends AbstractBean {

	private static final long serialVersionUID = 1L;

	private List<Equipamento> equipamentos;

	private List<Sensor> sensores;

	@Inject
	private Equipamento equipamento;

	@Inject
	private Sensor sensor;

	@Inject
	private SensorService sensorService;
	
	@Inject
	private SensorHibernateDAO sensorHibernateDAO;
	
	private String aux = "Salvar";
	
	public CadastroSensorBean() {
	}

	public String editAction(Sensor sensor){
		sensor.setEditable(true);
		return null;
	}
	
	public String deletarAction(Sensor sensor){
		sensorService.deletar(sensor);
		atualizarLista();
		return null;
	}
	
	public String salvarAlteracoesAction(){
		this.updateSensores();
		atualizarLista();
		return null;
	}
	
	public void updateSensores(){
		sensorService.atualizarLista(sensores);
	}

	
	@Inject
	public CadastroSensorBean(EquipamentoHibernateDAO equipamentoHibernateDAO,
			DadosSessao dadosSessao) {
		this.equipamentos = equipamentoHibernateDAO
				.buscarEquipamentosUsuario(dadosSessao.getUsuario().getId());
		equipamento = new Equipamento();
	}

	public void cadastrar() {
		sensor.setEquipamento(equipamento);
		sensor.setDataCadastro(new Date());
		sensorService.salvar(sensor);
		
		atualizarLista();
		
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public void atualizarLista(AjaxBehaviorEvent e) {
		
		if (equipamento.getId() != null) {
			this.sensores = sensorHibernateDAO
					.buscarSensoresEquipamento(equipamento.getId());
		}else{
			sensores.clear();
		}
	}
	
	public void atualizarLista() {
		
		if (equipamento.getId() != null) {
			this.sensores = sensorHibernateDAO
					.buscarSensoresEquipamento(equipamento.getId());
		}else{
			sensores.clear();
		}
	}

	
	public void teste(AjaxBehaviorEvent e) {
		this.aux = this.aux + "mudei";
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

	public List<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(List<Sensor> sensores) {
		this.sensores = sensores;
	}

	public String getAux() {
		return aux;
	}

	public void setAux(String aux) {
		this.aux = aux;
	}
	

	
	

}
