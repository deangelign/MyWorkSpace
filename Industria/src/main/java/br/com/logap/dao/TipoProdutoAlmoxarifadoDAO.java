package br.com.logap.dao;

import java.util.List;


import br.com.logap.modelo.TipoProdutoAlmoxarifado;

public class TipoProdutoAlmoxarifadoDAO extends
		HibernateDAO<TipoProdutoAlmoxarifado> {

	public TipoProdutoAlmoxarifadoDAO() {
		super();
	}

	public void atualizarLista(
			List<TipoProdutoAlmoxarifado> tipoProdutoAlmoxarifados) {

		for (TipoProdutoAlmoxarifado tipoProdutoAlmoxarifado : tipoProdutoAlmoxarifados) {
			if (tipoProdutoAlmoxarifado.isEditable()) {
				tipoProdutoAlmoxarifado.setEditable(false);
				this.atualizar(tipoProdutoAlmoxarifado);
			}

		}

	}

}