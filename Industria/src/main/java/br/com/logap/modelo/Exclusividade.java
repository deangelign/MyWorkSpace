package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exclusividade")
public class Exclusividade {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="id_fornecedor")
	private long idFornecedor;
	
	@Column(name="id_fabricante")
	private long idFabricante;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public long getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(long idFabricante) {
		this.idFabricante = idFabricante;
	}	
}