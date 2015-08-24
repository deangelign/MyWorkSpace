package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="fabricante")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Fabricante extends PessoaJuridica{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="numero_funcionarios",nullable=true)
	private int numeroFuncionarios;
	
	@Transient
	boolean editable;

	public Fabricante(){}

	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(int numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}	
	
	
	

	
}