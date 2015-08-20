package br.com.logap.modelo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.logap.dao.ModeloPersistencia;

@Entity
@Table(name="produto_venda")
public class ProdutoVenda extends ModeloPersistencia{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	@Column(name="quantidade_produto_comprada",nullable=false)
	private int quantidadeProdutoComprada;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_venda")
	private Venda venda;
	
	public ProdutoVenda() {
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidadeProdutoComprada() {
		return quantidadeProdutoComprada;
	}

	public void setQuantidadeProdutoComprada(int quantidadeProdutoComprada) {
		this.quantidadeProdutoComprada = quantidadeProdutoComprada;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	
	
}
