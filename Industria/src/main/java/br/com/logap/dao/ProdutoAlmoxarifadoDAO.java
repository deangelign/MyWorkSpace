package br.com.logap.dao;

import java.util.List;

import br.com.logap.modelo.Produto;
import br.com.logap.modelo.ProdutoAlmoxarifado;


public class ProdutoAlmoxarifadoDAO extends HibernateDAO<ProdutoAlmoxarifado>{

	public ProdutoAlmoxarifadoDAO(){
		super();		
	}

	public void atualizarLista(List<ProdutoAlmoxarifado> produtos_almoxarifados) {
		for (ProdutoAlmoxarifado produto_almoxarifado : produtos_almoxarifados) {
			if (produto_almoxarifado.isEditable()) {
				produto_almoxarifado.setEditable(false);
				this.atualizar(produto_almoxarifado);
			}
		}	
	}


}