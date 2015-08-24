package br.com.logap.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.logap.dao.ClienteDAO;
import br.com.logap.dao.UsuarioDAO;
import br.com.logap.dao.VendedorDAO;
import br.com.logap.modelo.Cliente;
import br.com.logap.modelo.Usuario;
import br.com.logap.modelo.Vendedor;

@ManagedBean(name = "vendedorBean")
@ViewScoped
public class VendedorBean {

	
		private Vendedor vendedor;
		
		private Usuario usuario;
			
		private VendedorDAO vendedorDAO;
		
		private UsuarioDAO usuarioDAO;
		
		private List<Vendedor>Vendedores ;
		
		public VendedorBean() {
			usuario = new Usuario();
			vendedor = new Vendedor();
			vendedorDAO =  new VendedorDAO();
			usuarioDAO = new UsuarioDAO();
		}
		
		public void atualziarLista(){
			Vendedores = vendedorDAO.buscarTodos();
		}

		
				
		
		public void cadastrar(){
			
			usuario.setTipoUsuario('c');
			usuarioDAO.inserir(usuario);
			
			vendedor.update(usuario);
			vendedorDAO.inserir(vendedor);
			
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Vendedor getVendedor() {
			return vendedor;
		}

		public void setVendedor(Vendedor vendedor) {
			this.vendedor = vendedor;
		}

		public List<Vendedor> getVendedores() {
			return Vendedores;
		}

		public void setVendedores(List<Vendedor> vendedores) {
			Vendedores = vendedores;
		}
		
		public void atualizarLista(){
			Vendedores = vendedorDAO.buscarTodos();
		}
		
		public void deletarAction(Vendedor vendedor){
			
			vendedorDAO.remover(vendedor);
			this.atualizarLista();
		}
		
		public void salvarAlteracoesAction(){
			vendedorDAO.atualizarLista(Vendedores);
			this.atualizarLista();
		}


		
		
		
		
			
		
}
