package br.com.logap.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.logap.dao.AlmoxarifadoDAO;
import br.com.logap.dao.ClienteDAO;
import br.com.logap.dao.ProdutoDAO;
import br.com.logap.dao.VendedorDAO;
import br.com.logap.modelo.Almoxarifado;
import br.com.logap.modelo.Cliente;
import br.com.logap.modelo.Produto;
import br.com.logap.modelo.Venda;
import br.com.logap.modelo.Vendedor;

@ManagedBean(name = "cadastrarVendaBean")
@SessionScoped
public class CadastrarVendaBean {
	private Venda venda;
	
	private Vendedor vendedor;
	private VendedorDAO daoV;
	
	private Cliente almoxarifado;
	private ClienteDAO daoC;
	
	public CadastrarVendaBean(){
		venda = new Venda();
		vendedor = new Vendedor();
		daoV = new VendedorDAO();
		daoC = new ClienteDAO();
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Cliente almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

}
