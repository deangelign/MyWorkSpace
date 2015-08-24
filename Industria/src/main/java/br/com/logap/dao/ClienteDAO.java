package br.com.logap.dao;

import java.util.List;

import br.com.logap.modelo.Cliente;

public class ClienteDAO extends HibernateDAO<Cliente> {

	public ClienteDAO() {
		super();
	}

	public void atualizarLista(List<Cliente> clientes) {

		for (Cliente cliente : clientes) {
			if (cliente.isEditable()) {
				cliente.setEditable(false);
				this.atualizar(cliente);
			}

		}

	}
}