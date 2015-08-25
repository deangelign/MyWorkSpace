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
import br.com.logap.dao.TipoProdutoAlmoxarifadoDAO;
import br.com.logap.dao.TipoProdutoDAO;
import br.com.logap.dao.UsuarioDAO;
import br.com.logap.modelo.Almoxarifado;
import br.com.logap.modelo.Cliente;
import br.com.logap.modelo.Exclusividade;
import br.com.logap.modelo.Produto;
import br.com.logap.modelo.ProdutoAlmoxarifado;
import br.com.logap.modelo.TipoProduto;
import br.com.logap.modelo.TipoProdutoAlmoxarifado;
import br.com.logap.modelo.Usuario;

@ManagedBean(name = "tipoProdutoAlmoxarifadoBean")
@ViewScoped
public class TipoProdutoAlmoxarifadoBean {

	TipoProdutoAlmoxarifado tipoProdutoAlmoxarifado;
	TipoProdutoAlmoxarifadoDAO tipoProdutoAlmoxarifadoDAO;
	
	TipoProduto tipoProduto;
	TipoProdutoDAO tipoProdutoDAO;
	
	Almoxarifado almoxarifado;
	AlmoxarifadoDAO almoxarifadoDAO;
	
	List<Almoxarifado>almoxarifados;
	List<TipoProduto>tipoProdutos;
	List<TipoProdutoAlmoxarifado>tipoProdutoAlmoxarifados;
	
	public TipoProdutoAlmoxarifadoBean() {
		tipoProdutoAlmoxarifado = new TipoProdutoAlmoxarifado();
		tipoProdutoAlmoxarifadoDAO = new TipoProdutoAlmoxarifadoDAO();
		
		tipoProduto = new TipoProduto();
		tipoProdutoDAO = new TipoProdutoDAO();
		
		almoxarifado = new Almoxarifado();
		almoxarifadoDAO = new AlmoxarifadoDAO();
	}

	public void atualizarLista() {
		tipoProdutoAlmoxarifados = tipoProdutoAlmoxarifadoDAO.buscarTodos();
	}
	
	public void cadastrar(){
		tipoProdutoAlmoxarifadoDAO.inserir(tipoProdutoAlmoxarifado);
		atualizarLista();
	}
	
	public void atualizarListas(){
		almoxarifados = almoxarifadoDAO.buscarTodos();
		tipoProdutos = tipoProdutoDAO.buscarTodos();
	}
	
	public void editAction(TipoProdutoAlmoxarifado _tipoProdutoAlmoxarifado){
		_tipoProdutoAlmoxarifado.setEditable(true);
	}
	
	public void deletarAction(TipoProdutoAlmoxarifado _tipoProdutoAlmoxarifado) {
		tipoProdutoAlmoxarifadoDAO.remover(_tipoProdutoAlmoxarifado);
		this.atualizarLista();
	}
	
	public void salvarAlteracoesAction(){
		tipoProdutoAlmoxarifadoDAO.atualizarLista(tipoProdutoAlmoxarifados);
	}
	

	public TipoProdutoAlmoxarifado getTipoProdutoAlmoxarifado() {
		return tipoProdutoAlmoxarifado;
	}

	public void _tipoProdutoAlmoxarifado(
			TipoProdutoAlmoxarifado tipoProdutoAlmoxarifado) {
		this.tipoProdutoAlmoxarifado = tipoProdutoAlmoxarifado;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

	public List<Almoxarifado> getAlmoxarifados() {
		return almoxarifados;
	}

	public void setAlmoxarifados(List<Almoxarifado> almoxarifados) {
		this.almoxarifados = almoxarifados;
	}

	public List<TipoProduto> getTipoProdutos() {
		return tipoProdutos;
	}

	public void setTipoProdutos(List<TipoProduto> tipoProdutos) {
		this.tipoProdutos = tipoProdutos;
	}

	public List<TipoProdutoAlmoxarifado> getTipoProdutoAlmoxarifados() {
		return tipoProdutoAlmoxarifados;
	}

	public void setTipoProdutoAlmoxarifados(
			List<TipoProdutoAlmoxarifado> tipoProdutoAlmoxarifados) {
		this.tipoProdutoAlmoxarifados = tipoProdutoAlmoxarifados;
	}
	

	
	
	
	
	
	
	


}
