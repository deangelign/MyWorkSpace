package br.com.projetobase.web;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetobase.arq.util.DadosSessao;
import br.com.projetobase.dao.hibernate.EquipamentoHibernateDAO;
import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.modelo.Sensor;
import br.com.projetobase.web.service.SensorService;

@Named
@javax.faces.view.ViewScoped
public class CadastroSensorBean extends AbstractBean{

	private static final long serialVersionUID = 1L;
	


	private List<Equipamento> equipamentos;
	
	
	private List<Sensor> sensores;
	
	@Inject
	private Equipamento equipamento;
	
	@Inject
	private Sensor sensor;
	
	@Inject
	private SensorService sensorService;
	
	public void cadastrar(){
		sensor.setEquipamento(equipamento);
		System.out.println("aaaaaaaaaaaaaa");
		System.out.println(sensor.getNome());
		sensorService.salvar(sensor);
	}
	
	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	


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

	public List<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(List<Sensor> sensores) {
		this.sensores = sensores;
	}
	
	
	
	
	
	
	
	
	
	
}
