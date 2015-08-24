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
	private String cnpj;
	
	@Column(name="sigla", nullable=true)
	private String sigla;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	
	
	
	
}
