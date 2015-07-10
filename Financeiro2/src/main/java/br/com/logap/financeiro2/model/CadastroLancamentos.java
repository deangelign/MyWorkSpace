package br.com.logap.financeiro2.model;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.com.logap.financeiro2.repository.Lancamentos;
import br.com.logap.financeiro2.util.Transactional;

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
	public void salvar(Lancamento lancamento) throws NegocioException {

		if (lancamento.getDataPagamento() != null
				&& lancamento.getDataPagamento().after(new Date())) {
			throw new NegocioException(
					"Data de pagamento nao pode ser uma data futura");
		}
		System.out.println("miau3");
		this.lancamentos.adicionar(lancamento);
		System.out.println("miau4");
	}

}
