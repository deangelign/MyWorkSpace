package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.logap.dao.ModeloPersistencia;

@Entity
@Table(name="almoxarifado")
public class Almoxarifado extends ModeloPersistencia {
	
	@Column(name="tipo_produto")
	private long tipoProduto;

	public Almoxarifado(){}
	
	public long getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(long tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
}