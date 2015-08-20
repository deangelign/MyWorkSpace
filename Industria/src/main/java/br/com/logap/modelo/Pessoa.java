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
	
	@Column(name="endereco", nullable=false)
	private String endereco;
	
	@Column(name="telefone", nullable=true)
	private String telefone;
	
	@Column(name="email", nullable=true)
	private String email;
	
	public Pessoa(){}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}