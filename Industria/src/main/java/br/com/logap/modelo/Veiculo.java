package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.logap.dao.ModeloPersistencia;

@Entity
@Table(name="veiculo")
public class Veiculo extends ModeloPersistencia{	
	

	@Column(name="tipo_veiculo", nullable=false)
	private String tipoVeiculo;
	
	public Veiculo(){}

	
	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
}