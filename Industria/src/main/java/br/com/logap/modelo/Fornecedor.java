package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="fornecedor")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Fornecedor extends PessoaJuridica{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="representante_comercial",nullable=true)
	private String representanteComercial;
	
	@Transient
	boolean editable;
	
	public Fornecedor(){}

	public String getRepresentanteComercial() {
		return representanteComercial;
	}

	public void setRepresentanteComercial(String representanteComercial) {
		this.representanteComercial = representanteComercial;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	
	
}