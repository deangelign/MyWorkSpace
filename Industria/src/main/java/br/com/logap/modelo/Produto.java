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
@Table(name = "produto")
public class Produto extends ModeloPersistencia {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "nome_Produto", nullable = false)
	private String nomeProduto;
		
	@Column(name = "preco_Compra", nullable = false)
	private String precoCompra;
	
	@Column(name = "preco_Venda", nullable = false)
	private Long precoVenda;	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_exclusividade", nullable = true)
	private Exclusividade exclusividade;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_produto", nullable = false)
	private TipoProduto tipoProduto;
	
	
	
	@Transient
	boolean editable;
	
	public Produto(){}
	

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
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


	public boolean isEditable() {
		return editable;
	}


	public void setEditable(boolean editable) {
		this.editable = editable;
	}


	public Exclusividade getExclusividade() {
		return exclusividade;
	}


	public void setExclusividade(Exclusividade exclusividade) {
		this.exclusividade = exclusividade;
	}


	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}


	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	
	
	
	
}