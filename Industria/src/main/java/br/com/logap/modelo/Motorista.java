package br.com.logap.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="motorista")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Motorista extends PessoaFisica{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_veiculo")
	private Veiculo veiculo;
	
	@Column(name="numero_habilitacao",nullable=false)
	private String numeroHabilitacao;
	
	@Transient
	boolean editable;
	
	public Motorista(){}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getNumeroHabilitacao() {
		return numeroHabilitacao;
	}

	public void setNumeroHabilitacao(String numeroHabilitacao) {
		this.numeroHabilitacao = numeroHabilitacao;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	
	
}