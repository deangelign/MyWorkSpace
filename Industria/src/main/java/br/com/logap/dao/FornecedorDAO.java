package br.com.logap.dao;

import java.util.List;

import br.com.logap.modelo.Fornecedor;


public class FornecedorDAO extends HibernateDAO<Fornecedor>{
	
	public FornecedorDAO(){
		super();		
	}

	public void atualizarLista(List<Fornecedor> fornecedors) {
		for (Fornecedor fornecedor : fornecedors) {
			if (fornecedor.isEditable()) {
				fornecedor.setEditable(false);
				this.atualizar(fornecedor);
			}

		}
		
	}
}