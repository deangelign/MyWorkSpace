package br.com.logap.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.logap.dao.AlmoxarifadoDAO;
import br.com.logap.dao.ExclusividadeDAO;
import br.com.logap.dao.ProdutoAlmoxarifadoDAO;
import br.com.logap.dao.ProdutoDAO;
import br.com.logap.dao.TipoProdutoDAO;
import br.com.logap.dao.UsuarioDAO;
import br.com.logap.modelo.Almoxarifado;
import br.com.logap.modelo.Cliente;
import br.com.logap.modelo.Exclusividade;
import br.com.logap.modelo.Produto;
import br.com.logap.modelo.ProdutoAlmoxarifado;
import br.com.logap.modelo.TipoProduto;
import br.com.logap.modelo.Usuario;

@ManagedBean(name = "produtoAlmoxarifadoBean")
@ViewScoped
public class ProdutoAlmoxarifadoBean {

	private ProdutoAlmoxarifado produtoAlmoxarifado;
	private Produto produto;
	private Almoxarifado almoxarifado;

	private ProdutoAlmoxarifadoDAO produtoAlmoxarifadoDAO;
	private ProdutoDAO produtoDAO;
	private AlmoxarifadoDAO almoxarifadoDAO;

	private List<ProdutoAlmoxarifado> produtoAlmoxarifados;
	private List<Produto> produtos;
	private List<Almoxarifado> almoxarifados;

	public ProdutoAlmoxarifadoBean() {
		produtoAlmoxarifado = new ProdutoAlmoxarifado();
		produto = new Produto();
		almoxarifado = new Almoxarifado();

		produtoAlmoxarifadoDAO = new ProdutoAlmoxarifadoDAO();
		produtoDAO = new ProdutoDAO();
		almoxarifadoDAO = new AlmoxarifadoDAO();

	}

	public void atualizarLista() {
		produtoAlmoxarifados = produtoAlmoxarifadoDAO.buscarTodos();
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

	public List<ProdutoAlmoxarifado> getProdutoAlmoxarifados() {
		return produtoAlmoxarifados;
	}

	public void setProdutoAlmoxarifados(
			List<ProdutoAlmoxarifado> produtoAlmoxarifados) {
		this.produtoAlmoxarifados = produtoAlmoxarifados;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Almoxarifado> getAlmoxarifados() {
		return almoxarifados;
	}

	public void setAlmoxarifados(List<Almoxarifado> almoxarifados) {
		this.almoxarifados = almoxarifados;
	}

	public void atualizarListas() {
		produtos = produtoDAO.buscarTodos();
		almoxarifados = almoxarifadoDAO.buscarTodos();
	}

	public ProdutoAlmoxarifado getProdutoAlmoxarifado() {
		return produtoAlmoxarifado;
	}

	public void setProdutoAlmoxarifado(ProdutoAlmoxarifado produtoAlmoxarifado) {
		this.produtoAlmoxarifado = produtoAlmoxarifado;
	}

	public void cadastrar() {
		Produto produto1 = produtoDAO.buscar(produto.getId());
		Almoxarifado almoxarifado1 = almoxarifadoDAO.buscar(almoxarifado
				.getId());
		produtoAlmoxarifado.setProduto(produto1);
		produtoAlmoxarifado.setAlmoxarifado(almoxarifado1);
		produtoAlmoxarifadoDAO.inserir(produtoAlmoxarifado);
		atualizarLista();
	}

	public void editAction(ProdutoAlmoxarifado proAlmoxarifado) {
		proAlmoxarifado.setEditable(true);
	}

	public void deletarAction(ProdutoAlmoxarifado proAlmoxarifado) {
		produtoAlmoxarifadoDAO.remover(proAlmoxarifado);
		this.atualizarLista();
	}
	
	public void salvarAlteracoesAction(){
		produtoAlmoxarifadoDAO.atualizarLista(produtoAlmoxarifados);
		this.atualizarLista();
	}
	

}
