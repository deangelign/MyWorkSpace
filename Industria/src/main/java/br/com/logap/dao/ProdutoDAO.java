package br.com.logap.dao;

import java.util.List;

import br.com.logap.modelo.Produto;


public class ProdutoDAO extends HibernateDAO<Produto>{

	public ProdutoDAO(){
		super();		
	}

	public void atualizarLista(List<Produto> produtos) {
		for (Produto produto : produtos) {
			if (produto.isEditable()) {
				produto.setEditable(false);
				this.atualizar(produto);
			}

		}
		
	}


}