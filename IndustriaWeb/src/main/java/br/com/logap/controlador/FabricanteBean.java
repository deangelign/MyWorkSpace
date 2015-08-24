package br.com.logap.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.logap.dao.FabricanteDAO;
import br.com.logap.dao.UsuarioDAO;
import br.com.logap.modelo.Fabricante;
import br.com.logap.modelo.Usuario;

@ManagedBean(name = "fabricanteBean")
@ViewScoped
public class FabricanteBean {

	
		private Fabricante fabricante;
		private FabricanteDAO fabricanteDAO;		
		private List<Fabricante>fabricantes ;
		
		public FabricanteBean() {
			fabricante = new Fabricante();
			fabricanteDAO =  new FabricanteDAO();
		}
		
		public void atualizarLista(){
			fabricantes = fabricanteDAO.buscarTodos();
		}

		public Fabricante getFabricante() {
			return fabricante;
		}
		
		

		public List<Fabricante> getFabricantes() {
			return fabricantes;
		}

		public void setFabricantes(List<Fabricante> fabricantes) {
			this.fabricantes = fabricantes;
		}

		public void setFabricante(Fabricante fabricante) {
			this.fabricante = fabricante;
		}
		
		public void cadastrar(){
						
			fabricanteDAO.inserir(fabricante);
			atualizarLista();
			
		}

				
		
		public void editAction(Fabricante fabricante){
			fabricante.setEditable(true);
		}
		
		public void deletarAction(Fabricante fabricante){
			
			//usuario  = usuarioDAO.buscarPorLogin(fabricante.getLogin());
			//System.out.println(usuario.getLogin());
			//usuarioDAO.remover(usuario);
			fabricanteDAO.remover(fabricante);
			
			this.atualizarLista();
		}
		
		public void salvarAlteracoesAction(){
			fabricanteDAO.atualizarLista(fabricantes);
			this.atualizarLista();
		}
		
		
		
		
		
		
		
		
			
		
}
