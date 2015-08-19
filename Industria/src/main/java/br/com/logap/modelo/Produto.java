package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.logap.dao.ModeloPersistencia;


@Entity
@Table(name = "produto")
public class Produto extends ModeloPersistencia {	
	
	@Column(name = "nome_Produto", nullable = false)
	private String nomeProduto;
	
	@Column(name = "tipo_Produto", nullable = false)
	private String tipoProduto;
	
	@Column(name = "preco_Compra", nullable = false)
	private String precoCompra;
	
	@Column(name = "preco_Venda", nullable = false)
	private Long precoVenda;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_venda")
	private Venda venda;
	
	public Produto(){}
	

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
	
	
	

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Long getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Long precoVenda) {
		this.precoVenda = precoVenda;
	}
}