package br.com.logap.financeiro.model;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.com.logap.financeiro.repository.Lancamentos;
import br.com.logap.financeiro.util.Transactional;

public class CadastroLancamentos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Lancamentos lancamentos;
	
	public CadastroLancamentos() {
	}
	
	@Inject
	public CadastroLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	@Transactional
	public void salvar(Lancamentos lancamentos) throws NegocioException{
		this.lancamentos = lancamentos;
	}
	
	public void salvar(Lancamento lancamento) throws NegocioException{
		
		if(lancamento.getDataPagamento() != null && lancamento.getDataPagamento().after(new Date())){
			throw new NegocioException("Data de pagamento nao pode ser uma data futura");
		}
		
		this.lancamentos.adicionar(lancamento);
	}
	
	
}
