package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.logap.dao.ModeloPersistencia;

@Entity
@Table(name="tipoProduto")
public class TipoProduto extends ModeloPersistencia{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="tipo_produto")
	private int tipoProduto;
	
	@Column(name="id_produto")
	private long idProduto;
	
	public TipoProduto(){}

	public int getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(int tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}
}