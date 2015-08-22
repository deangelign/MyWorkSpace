package br.com.logap.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.logap.dao.AlmoxarifadoDAO;
import br.com.logap.dao.ProdutoDAO;
import br.com.logap.modelo.Almoxarifado;
import br.com.logap.modelo.Produto;

@ManagedBean(name = "cadastrarProdutoBean")
@SessionScoped
public class CadastrarProdutoBean {
	private Produto produto;
	private ProdutoDAO daoP;
	
	private Almoxarifado almoxarifado;
	private AlmoxarifadoDAO daoA;
	
	public CadastrarProdutoBean(){
		produto = new Produto();
		almoxarifado = new Almoxarifado();
		daoP = new ProdutoDAO();
		daoA = new AlmoxarifadoDAO();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}
	
	public void cadastraProduto(){
		daoP.inserir(produto);
	}
	
	public void removerProduto(){
		daoP.remover(produto);
	}
	
	public void atualizarProduto(){
		daoP.atualizar(produto);
	}
	
	public void listarProdutos(){
		daoP.buscarTodos();		
	}
}