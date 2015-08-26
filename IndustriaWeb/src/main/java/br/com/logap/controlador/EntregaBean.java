package br.com.logap.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.logap.dao.EntregaDAO;
import br.com.logap.dao.MotoristaDAO;
import br.com.logap.modelo.Entrega;
import br.com.logap.modelo.Motorista;


@ManagedBean(name = "entregaBean")
@ViewScoped
public class EntregaBean {

	private Entrega entrega;
	private EntregaDAO entregaDAO;
	
	private MotoristaDAO motoristaDAO;
	
	List<Motorista>motoristas;
	List<Entrega>entregas;
	
	public EntregaBean(){
		entrega = new Entrega();
		entregaDAO = new EntregaDAO();
		motoristaDAO = new MotoristaDAO();
	}
	
	public void cadastrar(){
		String dataEntrega = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("dataEntrega");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			entrega.setDataHora(formatter.parse(dataEntrega));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		entregaDAO.inserir(entrega);
		atualizarLista();
	}
	
	public void editAction(Entrega _entrega){
		_entrega.setEditable(true);
	}
	
	public void deletarAction(Entrega _entrega){
		entregaDAO.remover(_entrega);
		atualizarLista();
	}
	
	public void salvarAlteracoesAction(){
		
		
		
		
		entregaDAO.atualizarLista(entregas);
		this.atualizarLista();
	}
	
	public void atualizarListas() {
		motoristas = motoristaDAO.buscarTodos();
	}
	
	public void atualizarLista() {
		entregas = entregaDAO.buscarTodos();
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}

	public List<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}
	
	
	
	
	
	
	
	
}
