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
	private int id;
	
	@Column(name="id_mortorista", nullable=false)
	private int idMotorista;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMotorista() {
		return idMotorista;
	}

	public void setIdMotorista(int idMotorista) {
		this.idMotorista = idMotorista;
	}
}