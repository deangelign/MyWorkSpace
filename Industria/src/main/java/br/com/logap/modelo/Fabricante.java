package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="fabricante")
public class Fabricante extends Pessoa{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="telefone_fabricante",nullable=false)
	private String telefone;

	public Fabricante(){}	

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
}