package br.com.logap.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.logap.dao.ModeloPersistencia;

@Entity
@Table(name="produto_almoxarifado")
public class ProdutoAlmoxarifado extends ModeloPersistencia {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	@Column(name="quantidade_produto_estoque",nullable=false)
	private int quantidadeProdutoEstoque;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_almoxarifado")
	private Almoxarifado almoxarifado;

	@Transient
	boolean editable;
	
	public ProdutoAlmoxarifado() {
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidadeProdutoEstoque() {
		return quantidadeProdutoEstoque;
	}

	public void setQuantidadeProdutoEstoque(int quantidadeProdutoEstoque) {
		this.quantidadeProdutoEstoque = quantidadeProdutoEstoque;
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	
	
	


	
}
