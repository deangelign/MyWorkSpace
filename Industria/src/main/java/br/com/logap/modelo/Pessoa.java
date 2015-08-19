package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import br.com.logap.dao.ModeloPersistencia;

@MappedSuperclass
public class Pessoa extends ModeloPersistencia{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="nome_pessoa", nullable=false)
	private String nome;
	
	@Column(name="tipo_pessoa", nullable=false)
	private String tipoPessoa;
	
	public Pessoa(){}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
}