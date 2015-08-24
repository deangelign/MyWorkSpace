package br.com.logap.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.logap.dao.FornecedorDAO;
import br.com.logap.dao.UsuarioDAO;
import br.com.logap.modelo.Fornecedor;
import br.com.logap.modelo.Usuario;

@ManagedBean(name = "fornecedorBean")
@ViewScoped
public class FonecedorBean {

	
		private Fornecedor fornecedor;
		private FornecedorDAO fornecedorDAO;		
		private List<Fornecedor>fornecedors ;
		
		public FonecedorBean() {
			fornecedor = new Fornecedor();
			fornecedorDAO =  new FornecedorDAO();
		}
		
		public void atualizarLista(){
			fornecedors = fornecedorDAO.buscarTodos();
		}

		public Fornecedor getFornecedor() {
			return fornecedor;
		}
		
		

		public List<Fornecedor> getFornecedors() {
			return fornecedors;
		}

		public void setFornecedors(List<Fornecedor> fornecedors) {
			this.fornecedors = fornecedors;
		}

		public void setFornecedor(Fornecedor fornecedor) {
			this.fornecedor = fornecedor;
		}
		
		public void cadastrar(){
						
			fornecedorDAO.inserir(fornecedor);
			atualizarLista();
			
		}

				
		
		public void editAction(Fornecedor fornecedor){
			fornecedor.setEditable(true);
		}
		
		public void deletarAction(Fornecedor fornecedor){
			
			fornecedorDAO.remover(fornecedor);
			this.atualizarLista();
		}
		
		public void salvarAlteracoesAction(){
			fornecedorDAO.atualizarLista(fornecedors);
			this.atualizarLista();
		}
		
		
		
		
		
		
		
		
		
		
			
		
}
