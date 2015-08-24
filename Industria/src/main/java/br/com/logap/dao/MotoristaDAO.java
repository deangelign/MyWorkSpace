package br.com.logap.dao;

import java.util.List;

import br.com.logap.modelo.Motorista;


public class MotoristaDAO extends HibernateDAO<Motorista>{

	public MotoristaDAO(){
		super();		
	}

	public void atualizarLista(List<Motorista> motoristas) {
		
		for (Motorista motorista : motoristas) {
			if (motorista.isEditable()) {
				motorista.setEditable(false);
				this.atualizar(motorista);
			}

		}

		
	}	
}
