package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "vendedor")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vendedor extends Usuario{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="numero_vendedor",nullable=false)
	private int numeroVendedor;
	
	public Vendedor(){}

	public int getNumeroVendedor() {
		return numeroVendedor;
	}

	public void setNumeroVendedor(int numeroVendedor) {
		this.numeroVendedor = numeroVendedor;
	}
	
	
}