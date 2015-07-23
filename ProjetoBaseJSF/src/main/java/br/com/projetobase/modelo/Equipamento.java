package br.com.projetobase.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.projetobase.arq.modelo.ModeloPersistencia;



@Entity
@Table(name = "equipamento")
public class Equipamento extends ModeloPersistencia{
	
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	

	public Equipamento() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
