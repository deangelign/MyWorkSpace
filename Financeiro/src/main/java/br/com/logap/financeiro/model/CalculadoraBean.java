package br.com.logap.financeiro.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CalculadoraBean {

	private double valorA;
	private double valorB;
	private double resultado;
	
	public void somar(){
		this.resultado = this.valorA + this.valorB;
	}

	public double getValorA() {
		return valorA;
	}

	public void setValorA(double valorA) {
		this.valorA = valorA;
	}

	public double getValorB() {
		return valorB;
	}

	public void setValorB(double valorB) {
		this.valorB = valorB;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
	
	
	
}
