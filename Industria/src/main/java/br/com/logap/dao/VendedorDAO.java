package br.com.logap.dao;

import java.util.List;

import br.com.logap.modelo.Cliente;
import br.com.logap.modelo.Vendedor;

public class VendedorDAO extends HibernateDAO<Vendedor> {

	public VendedorDAO() {
		super();
	}

	public void atualizarLista(List<Vendedor> vendedores) {
		
		for (Vendedor vendedor : vendedores) {
			if (vendedor.isEditable()) {
				vendedor.setEditable(false);
				this.atualizar(vendedor);
			}

		}

	}
}