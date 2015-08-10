package br.com.logap.servicoHistorico.all;

import java.sql.Timestamp;
import java.util.Random;

public class Historico {
	
	Long id;
	
	double valor;
	
	Timestamp tempo;
	
	Long id_sensor;
	
	

	public Historico() {
		double var = 20;
		double media = 0;
		
		Random random = new Random();
		this.valor = media + ( random.nextGaussian()*var );
		
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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getId_sensor() {
		return id_sensor;
	}


	public void setId_sensor(Long id_sensor) {
		this.id_sensor = id_sensor;
	}

	
	
	
	
}
