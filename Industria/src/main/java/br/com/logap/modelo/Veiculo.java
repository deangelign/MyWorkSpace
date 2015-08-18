package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="veiculo")
public class Veiculo {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_veiculo")
	private long id;
	
	public Veiculo(){}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}