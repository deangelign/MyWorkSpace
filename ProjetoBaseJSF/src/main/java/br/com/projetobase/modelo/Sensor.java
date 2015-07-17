package br.com.projetobase.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@SuppressWarnings("serial")
@Entity
@Table(name = "sensor")
public class Sensor {

	@NotEmpty
	@Column(name = "nome", nullable = false)
	private String nome;
	
	
	@OneToOne(optional = false)
	@JoinColumn(name = "equipamento_nome")
	private Equipamento equipamento;
	
}
