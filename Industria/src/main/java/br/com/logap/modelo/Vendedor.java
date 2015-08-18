package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "vendedor")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vendedor extends Pessoa{
	@Column(name="telefone_vendedor",nullable=false)
	private String telefone;
	
	public Vendedor(){}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
}