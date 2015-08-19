package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="fornecedor")
public class Fornecedor extends Pessoa{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="telefone_fornecedor",nullable=false)
	private String telefone;
		
	public Fornecedor(){}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
}