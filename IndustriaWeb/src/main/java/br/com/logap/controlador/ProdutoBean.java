package br.com.logap.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.logap.dao.ExclusividadeDAO;
import br.com.logap.dao.ProdutoDAO;
import br.com.logap.dao.TipoProdutoDAO;
import br.com.logap.dao.UsuarioDAO;
import br.com.logap.modelo.Exclusividade;
import br.com.logap.modelo.Produto;
import br.com.logap.modelo.TipoProduto;
import br.com.logap.modelo.Usuario;

@ManagedBean(name = "produtoBean")
@ViewScoped
public class ProdutoBean {

	
		private Produto produto;
		private Exclusividade exclusividade;
		private TipoProduto tipoProduto;
		
			
		private ProdutoDAO produtoDAO;
		private ExclusividadeDAO exclusividadeDAO;
		private TipoProdutoDAO tipoProdutoDAO;
		
		
		
		private List<Produto>produtos ;
		private List<Exclusividade>exclusividades;
		private List<TipoProduto>tipoProdutos;
		
		
		public ProdutoBean() {
			produto = new Produto();
			produtoDAO =  new ProdutoDAO();
			exclusividadeDAO = new ExclusividadeDAO();
			tipoProdutoDAO = new TipoProdutoDAO();
			
			tipoProduto = new TipoProduto();
			exclusividade = new Exclusividade();	
		}
		
		public void atualizarLista(){
			produtos = produtoDAO.buscarTodos();
		}

		
		public Produto getProduto() {
			return produto;
		}
		
		

		public List<Produto> getProdutos() {
			return produtos;
		}

		public void setProdutos(List<Produto> produtos) {
			this.produtos = produtos;
		}

		public void setProduto(Produto produto) {
			this.produto = produto;
		}
		
		public void cadastrar(){
			Exclusividade exclusividade1 = exclusividadeDAO.buscar(exclusividade.getId());
			TipoProduto tipoProduto1 = tipoProdutoDAO.buscar(tipoProduto.getId());
			produto.setExclusividade(exclusividade1);
			produto.setTipoProduto(tipoProduto1);
			produtoDAO.inserir(produto);			
			atualizarLista();
			
		}
		
		public void editAction(Produto produto){
			produto.setEditable(true);
		}
		
		public void deletarAction(Produto produto){
			produtoDAO.remover(produto);
			this.atualizarLista();
		}
		
		public void salvarAlteracoesAction(){
			produtoDAO.atualizarLista(produtos);
			this.atualizarLista();
		}

		public List<Exclusividade> getExclusividades() {
			return exclusividades;
		}

		public void setExclusividades(List<Exclusividade> exclusividades) {
			this.exclusividades = exclusividades;
		}
		
		public void atualizarListas(){
			exclusividades = exclusividadeDAO.buscarTodos();
			tipoProdutos = tipoProdutoDAO.buscarTodos();
		}

		public Exclusividade getExclusividade() {
			return exclusividade;
		}

		public void setExclusividade(Exclusividade exclusividade) {
			this.exclusividade = exclusividade;
		}

		public TipoProduto getTipoProduto() {
			return tipoProduto;
		}

		public void setTipoProduto(TipoProduto tipoProduto) {
			this.tipoProduto = tipoProduto;
		}

		public List<TipoProduto> getTipoProdutos() {
			return tipoProdutos;
		}

		public void setTipoProdutos(List<TipoProduto> tipoProdutos) {
			this.tipoProdutos = tipoProdutos;
		}
		
		
		
		
		
		
		
		
		
		
		
		
			
		
}
