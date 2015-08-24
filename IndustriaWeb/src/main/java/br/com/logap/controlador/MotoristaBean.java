package br.com.logap.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.logap.dao.MotoristaDAO;
import br.com.logap.dao.UsuarioDAO;
import br.com.logap.modelo.Motorista;
import br.com.logap.modelo.Usuario;

@ManagedBean(name = "motoristaBean")
@ViewScoped
public class MotoristaBean {

	
		private Motorista motorista;			
		private MotoristaDAO motoristaDAO;
		private List<Motorista>motoristas ;
		
		public MotoristaBean() {
			motorista = new Motorista();
			motoristaDAO =  new MotoristaDAO();
		}
		
		public void atualizarLista(){
			motoristas = motoristaDAO.buscarTodos();
		}

		public Motorista getMotorista() {
			return motorista;
		}
		
		

		public List<Motorista> getMotoristas() {
			return motoristas;
		}

		public void setMotoristas(List<Motorista> motoristas) {
			this.motoristas = motoristas;
		}

		public void setMotorista(Motorista motorista) {
			this.motorista = motorista;
		}
		
		public void cadastrar(){
			
			motoristaDAO.inserir(motorista);			
			atualizarLista();
			
		}

		
		
		public void editAction(Motorista motorista){
			motorista.setEditable(true);
		}
		
		public void deletarAction(Motorista motorista){
			
			motoristaDAO.remover(motorista);			
			this.atualizarLista();
		}
		
		public void salvarAlteracoesAction(){
			motoristaDAO.atualizarLista(motoristas);
			this.atualizarLista();
		}
		
		
		
		
		
		
			
		
}
