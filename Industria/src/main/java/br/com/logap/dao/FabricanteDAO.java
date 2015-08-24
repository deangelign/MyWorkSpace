package br.com.logap.dao;

import java.util.List;

import br.com.logap.modelo.Fabricante;

public class FabricanteDAO extends HibernateDAO<Fabricante>{
	
	public FabricanteDAO (){
		super();		
	}

	public void atualizarLista(List<Fabricante> fabricantes) {
		for (Fabricante fabricante : fabricantes) {
			if (fabricante.isEditable()) {
				fabricante.setEditable(false);
				this.atualizar(fabricante);
			}

		}

	}
	
}