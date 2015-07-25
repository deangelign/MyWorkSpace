package br.com.projetobase.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.projetobase.arq.modelo.ModeloPersistencia;



@Entity
@Table(name = "sensor")
public class Sensor extends ModeloPersistencia{

	@NotEmpty
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_equipamento", foreignKey = @ForeignKey(name = "fk_equipamento"))
	private Equipamento equipamento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	
	
}
