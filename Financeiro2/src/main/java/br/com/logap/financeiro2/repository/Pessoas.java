package br.com.logap.financeiro2.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.logap.financeiro2.model.Pessoa;

public class Pessoas {
	private EntityManager manager;
	
	@Inject
	public Pessoas(EntityManager manager){
		this.manager = manager;
	}
	
	public Pessoa PorId(long id){
		return manager.find(Pessoa.class, id);
	}
	
	public List<Pessoa> todas(){
		TypedQuery<Pessoa> query = manager.createQuery("from Pessoa", Pessoa.class);
		return query.getResultList();
	}
}
