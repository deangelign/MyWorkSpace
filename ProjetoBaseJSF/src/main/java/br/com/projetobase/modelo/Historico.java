package br.com.projetobase.modelo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.projetobase.arq.modelo.ModeloPersistencia;

@Entity
@Table(name = "historico")
public class Historico extends ModeloPersistencia {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "valor", nullable = true)
	double valor;
	
	@Column(name = "tempo", nullable = false)
	Timestamp tempo;
	
	@Column(name = "id_sensor", nullable = false)
	Long id_sensor;
	
	

	public Historico() {	
	}


	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Timestamp getTempo() {
		return tempo;
	}

	public void setTempo(Timestamp tempo) {
		this.tempo = tempo;
	}


	public Long getId_sensor() {
		return id_sensor;
	}


	public void setId_sensor(Long id_sensor) {
		this.id_sensor = id_sensor;
	}

	
	
	
	
}
