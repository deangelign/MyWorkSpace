package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.logap.dao.ModeloPersistencia;

@Entity
@Table(name="tipoProduto")
public class TipoProduto extends ModeloPersistencia{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="nome_tipo", nullable=false, unique=true)
	private String nomeTipo;
	
	
	public TipoProduto(){}


	public String getNomeTipo() {
		return nomeTipo;
	}


	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

	
	
	
}