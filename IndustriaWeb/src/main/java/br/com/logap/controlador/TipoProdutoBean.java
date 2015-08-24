package br.com.logap.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.logap.dao.TipoProdutoDAO;
import br.com.logap.dao.FabricanteDAO;
import br.com.logap.dao.FornecedorDAO;
import br.com.logap.dao.UsuarioDAO;
import br.com.logap.modelo.TipoProduto;
import br.com.logap.modelo.Fabricante;
import br.com.logap.modelo.Fornecedor;
import br.com.logap.modelo.Usuario;

@ManagedBean(name = "tipoProdutoBean")
@ViewScoped
public class TipoProdutoBean {

	
		private TipoProduto tipoProduto;
		private TipoProdutoDAO tipoProdutoDAO;		
		private List<TipoProduto>tipoProdutos ;
				
		public TipoProdutoBean() {
			tipoProduto = new TipoProduto();
			tipoProdutoDAO =  new TipoProdutoDAO();
		}
			
		public void atualizarLista(){
			tipoProdutos = tipoProdutoDAO.buscarTodos();
		}

		public TipoProduto getTipoProduto() {
			return tipoProduto;
		}
		
		public List<TipoProduto> getTipoProdutos() {
			return tipoProdutos;
		}

		public void setTipoProdutos(List<TipoProduto> tipoProdutos) {
			this.tipoProdutos = tipoProdutos;
		}

		public void setTipoProduto(TipoProduto tipoProduto) {
			this.tipoProduto = tipoProduto;
		}
		
		public void cadastrar(){
			tipoProdutoDAO.inserir(tipoProduto);
			atualizarLista();
		}

		public void deletarAction(TipoProduto tipoProduto){
			
			tipoProdutoDAO.remover(tipoProduto);
			this.atualizarLista();
		}
		
				
		
		
		
		
		
		
		
			
		
}
