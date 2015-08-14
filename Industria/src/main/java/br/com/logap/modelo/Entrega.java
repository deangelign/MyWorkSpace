package br.com.logap.modelo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="entrega")
public class Entrega {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="id_Motorista")
	private long idMotorista;

	@Column(name="id_Veiculo")
	private long idVeiculo;
	
	@Column(name="data_hora")
	private Timestamp dataHora;
}