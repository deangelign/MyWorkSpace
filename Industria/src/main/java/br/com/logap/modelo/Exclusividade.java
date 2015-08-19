package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.logap.dao.ModeloPersistencia;

@Entity
@Table(name="exclusividade")
public class Exclusividade extends ModeloPersistencia{
	
	@Column(name="id_fornecedor")
	private long idFornecedor;
	
	@Column(name="id_fabricante")
	private long idFabricante;
	
	public Exclusividade(){}
	

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