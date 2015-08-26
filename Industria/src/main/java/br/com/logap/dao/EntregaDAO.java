package br.com.logap.dao;

import java.util.List;

import br.com.logap.modelo.Entrega;
import br.com.logap.modelo.Fabricante;


public class EntregaDAO extends HibernateDAO<Entrega>{
	public EntregaDAO(){
		super();		
	}

	public void atualizarLista(List<Entrega> entregas) {
		
		for (Entrega entrega : entregas) {
			if (entrega.isEditable()) {
				entrega.setEditable(false);
				atualizar(entrega);
			}

		}

		
	}
}
