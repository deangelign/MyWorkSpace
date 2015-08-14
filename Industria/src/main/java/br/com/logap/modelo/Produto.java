package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nome_Produto", nullable = false)
	private String nomeProduto;
	
	@Column(name = "tipo_Produto", nullable = false)
	private String tipoProduto;
	
	@Column(name = "preco_Compra", nullable = false)
	private String precoCompra;
	
	@Column(name = "preco_Venda", nullable = false)
	private Long precoVenda;	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(String precoCompra) {
		this.precoCompra = precoCompra;
	}

	public Long getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Long precoVenda) {
		this.precoVenda = precoVenda;
	}
}