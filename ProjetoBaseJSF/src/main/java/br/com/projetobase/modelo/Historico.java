package br.com.projetobase.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import br.com.projetobase.arq.modelo.ModeloPersistencia;

@Entity
@Table(name = "historico")
@JsonIgnoreProperties({"sensor"})
//@JsonSerialize(using = JsonStdHistoricoSerializer.class)
public class Historico extends ModeloPersistencia {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "valor", nullable = true)
	double valor;
	
	@Column(name = "tempo", nullable = false)
	Date tempo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sensor")
	private Sensor sensor;

	public Historico() {	
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getTempo() {
		return tempo;
	}

	public void setTempo(Date tempo) {
		this.tempo = tempo;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

}
