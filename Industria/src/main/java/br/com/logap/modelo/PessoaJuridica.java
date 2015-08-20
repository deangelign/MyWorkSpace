package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PessoaJuridica extends Pessoa{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="CNPJ", nullable=false)
	private String CNPJ;
	
	@Column(name="sigla", nullable=true)
	private String sigla;
	
}
