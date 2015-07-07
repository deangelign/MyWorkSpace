package br.com.logap.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.logap.financeiro.model.Lancamento;

public class Lancamentos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	@Inject
	public Lancamentos(EntityManager manager){
		this.manager = manager;
	}
	
	public List<Lancamento> todos(){
		TypedQuery<Lancamento> query = manager.createQuery("from Lancamento", Lancamento.class);
		return query.getResultList();
	}
	
	public void adicionar(Lancamento lancamento) {
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.persist(lancamento);
		trx.commit();
	}
	
	public List<String> descricoesQueContem(String descricao) {
		TypedQuery<String> query = manager.createQuery(
		"select distinct descricao from Lancamento "
		+ "where upper(descricao) like upper(:descricao)",
		String.class);
		query.setParameter("descricao", "%" + descricao + "%");
		return query.getResultList();
	}
	
	public Lancamento porId(Long id) {
		return manager.find(Lancamento.class, id);
	}
	
	public Lancamento guardar(Lancamento lancamento) {
		return this.manager.merge(lancamento);
	}
	
}
