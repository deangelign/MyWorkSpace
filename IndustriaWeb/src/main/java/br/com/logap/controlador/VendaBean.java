package br.com.logap.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.logap.dao.ClienteDAO;
import br.com.logap.dao.EntregaDAO;
import br.com.logap.dao.MotoristaDAO;
import br.com.logap.dao.VendaDAO;
import br.com.logap.dao.VendedorDAO;
import br.com.logap.modelo.Cliente;
import br.com.logap.modelo.Entrega;
import br.com.logap.modelo.Motorista;
import br.com.logap.modelo.Venda;
import br.com.logap.modelo.Vendedor;

@ManagedBean(name = "vendaBean")
@ViewScoped
public class VendaBean {

	
		private Venda venda;			
		private VendaDAO vendaDAO;
		private List<Venda>vendas;
		
		private ClienteDAO clienteDAO;
		private EntregaDAO entregaDAO;
		private VendedorDAO vendedorDAO;
		
		private List<Cliente>clientes;
		private List<Vendedor>vendedores;
		private List<Entrega>entregas;
		
		
		public VendaBean() {
			venda = new Venda();
			
			vendaDAO = new VendaDAO();
			clienteDAO = new ClienteDAO();
			entregaDAO = new EntregaDAO();
			vendedorDAO = new VendedorDAO();
		}
		
		public void atualziarListas(){
			clientes = clienteDAO.buscarTodos();
			entregas = entregaDAO.buscarTodos();
			vendedores = vendedorDAO.buscarTodos();
		}
		
		public void atualziarLista(){
			vendas = vendaDAO.buscarTodos();
		}
		
		public void cadastrar(){
			Entrega entregaaux = entregaDAO.buscar(venda.getEntrega().getId());
			MotoristaDAO motoristaDAO = new MotoristaDAO();
			Motorista motorista = motoristaDAO.buscar(entregaaux.getMotorista().getId());
			venda.getEntrega().setMotorista(motorista);
			vendaDAO.inserir(venda);
			atualziarLista();
		}


		public Venda getVenda() {
			return venda;
		}

		public void setVenda(Venda venda) {
			this.venda = venda;
		}

		public List<Venda> getVendas() {
			return vendas;
		}

		public void setVendaes(List<Venda> vendas) {
			this.vendas = vendas;
		}
		
		
		public void deletarAction(Venda _venda){
			vendaDAO.remover(_venda);
			atualziarLista();
			
		}
		
		public void salvarAlteracoesAction(){
		}
		
		public void editAction(Venda venda){
		}

		public List<Cliente> getClientes() {
			return clientes;
		}

		public void setClientes(List<Cliente> clientes) {
			this.clientes = clientes;
		}

		public List<Vendedor> getVendedores() {
			return vendedores;
		}

		public void setVendedores(List<Vendedor> vendedores) {
			this.vendedores = vendedores;
		}

		public List<Entrega> getEntregas() {
			return entregas;
		}

		public void setEntregas(List<Entrega> entregas) {
			this.entregas = entregas;
		}

		public void setVendas(List<Venda> vendas) {
			this.vendas = vendas;
		}
		
		


		
		
		
		
			
		
}
