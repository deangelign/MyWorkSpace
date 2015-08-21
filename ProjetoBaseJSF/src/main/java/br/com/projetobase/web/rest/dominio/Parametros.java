package br.com.projetobase.web.rest.dominio;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.com.projetobase.web.rest.JsonStdHistoricoSerializer;

public class Parametros implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String dataInicio;
	private String dataFim;
	
	public Parametros() {
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	
	public String toString(){
		return "id: " + this.id + "\n" + "dataInicio: " + this.dataInicio + "\n" + "dataFim: " + dataFim;
	}
	
}
