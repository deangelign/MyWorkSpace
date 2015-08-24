package br.com.logap.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.logap.dao.ExclusividadeDAO;
import br.com.logap.dao.FabricanteDAO;
import br.com.logap.dao.FornecedorDAO;
import br.com.logap.dao.UsuarioDAO;
import br.com.logap.modelo.Exclusividade;
import br.com.logap.modelo.Fabricante;
import br.com.logap.modelo.Fornecedor;
import br.com.logap.modelo.Usuario;

@ManagedBean(name = "exclusividadeBean")
@ViewScoped
public class ExclusividadeBean {

	
		private Exclusividade exclusividade;
		private ExclusividadeDAO exclusividadeDAO;		
		private List<Exclusividade>exclusividades ;
		
		private FornecedorDAO fornecedorDAO;
		private FabricanteDAO fabricanteDAO;
		
		private List<Fornecedor>fornecedores;
		private List<Fabricante>fabricantes;
		
		public ExclusividadeBean() {
			exclusividade = new Exclusividade();
			exclusividadeDAO =  new ExclusividadeDAO();
			fornecedorDAO = new FornecedorDAO();
			fabricanteDAO = new FabricanteDAO();
		}
		
		public void atualizarListas(){
			fornecedores = fornecedorDAO.buscarTodos();
			fabricantes = fabricanteDAO.buscarTodos();
		}
		
		public void atualizarLista(){
			exclusividades = exclusividadeDAO.buscarTodos();
		}

		public Exclusividade getExclusividade() {
			return exclusividade;
		}
		
		

		public List<Exclusividade> getExclusividades() {
			return exclusividades;
		}

		public void setExclusividades(List<Exclusividade> exclusividades) {
			this.exclusividades = exclusividades;
		}

		public void setExclusividade(Exclusividade exclusividade) {
			this.exclusividade = exclusividade;
		}
		
		public void cadastrar(){
			
			Fornecedor fornecedor = fornecedorDAO.buscar(exclusividade.getFornecedor().getId());
			exclusividade.setFornecedor(fornecedor);
			
			Fabricante fabricante = fabricanteDAO.buscar(exclusividade.getFabricante().getId());
			exclusividade.setFabricante(fabricante);
			
			exclusividadeDAO.inserir(exclusividade);
			atualizarLista();
			
		}

				
		
		public void editAction(Exclusividade exclusividade){
			//exclusividade.setEditable(true);
		}
		
		public void deletarAction(Exclusividade exclusividade){
			
			exclusividadeDAO.remover(exclusividade);
			this.atualizarLista();
		}
		
		public void salvarAlteracoesAction(){
			//exclusividadeDAO.atualizarLista(exclusividades);
			this.atualizarLista();
		}

		public List<Fornecedor> getFornecedores() {
			return fornecedores;
		}

		public void setFornecedores(List<Fornecedor> fornecedores) {
			this.fornecedores = fornecedores;
		}

		public List<Fabricante> getFabricantes() {
			return fabricantes;
		}

		public void setFabricantes(List<Fabricante> fabricantes) {
			this.fabricantes = fabricantes;
		}
		
		
		
		
		
		
		
		
			
		
}
