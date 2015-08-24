package br.com.logap.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.logap.dao.ClienteDAO;
import br.com.logap.dao.UsuarioDAO;
import br.com.logap.modelo.Cliente;
import br.com.logap.modelo.Usuario;

@ManagedBean(name = "clienteBean")
@ViewScoped
public class ClienteBean {

	
		private Cliente cliente;
		
		private Usuario usuario;
			
		private ClienteDAO clienteDAO;
		
		private UsuarioDAO usuarioDAO;
		
		private List<Cliente>clientes ;
		
		public ClienteBean() {
			usuario = new Usuario();
			cliente = new Cliente();
			clienteDAO =  new ClienteDAO();
			usuarioDAO = new UsuarioDAO();
		}
		
		public void atualizarLista(){
			clientes = clienteDAO.buscarTodos();
		}

		public Cliente getCliente() {
			return cliente;
		}
		
		

		public List<Cliente> getClientes() {
			return clientes;
		}

		public void setClientes(List<Cliente> clientes) {
			this.clientes = clientes;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		
		public void cadastrar(){
			
			usuario.setTipoUsuario('c');
			usuarioDAO.inserir(usuario);
			
			cliente.update(usuario);
			clienteDAO.inserir(cliente);
			
			atualizarLista();
			
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		
		
		public void editAction(Cliente cliente){
			cliente.setEditable(true);
		}
		
		public void deletarAction(Cliente cliente){
			
			//usuario  = usuarioDAO.buscarPorLogin(cliente.getLogin());
			//System.out.println(usuario.getLogin());
			//usuarioDAO.remover(usuario);
			clienteDAO.remover(cliente);
			
			this.atualizarLista();
		}
		
		public void salvarAlteracoesAction(){
			clienteDAO.atualizarLista(clientes);
			this.atualizarLista();
		}
		
		
		
		
		
		
			
		
}
