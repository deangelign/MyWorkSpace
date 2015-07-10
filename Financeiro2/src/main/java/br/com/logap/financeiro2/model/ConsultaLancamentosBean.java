package br.com.logap.financeiro2.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.logap.financeiro2.repository.Lancamentos;
import br.com.logap.financeiro2.util.JpaUtil;

@Named
@ViewScoped
public class ConsultaLancamentosBean {

	private List<Lancamento> lancamentos;
	
	@Inject
	private Lancamentos lancamentosRepository;
	
	private static final long serialVersionUID = 1L;
	
	public void consultar(){
		this.lancamentos = lancamentosRepository.todos();
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
	
	
}
