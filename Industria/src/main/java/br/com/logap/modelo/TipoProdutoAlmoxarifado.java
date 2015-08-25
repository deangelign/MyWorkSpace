package br.com.logap.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.logap.dao.ModeloPersistencia;

@Entity
@Table(name="tipo_produto_almoxarifado")
public class TipoProdutoAlmoxarifado extends ModeloPersistencia {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_produto")
	private TipoProduto tipoProduto;
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_almoxarifado")
	private Almoxarifado almoxarifado;
	
	@Transient
	boolean editable;

	public TipoProdutoAlmoxarifado() {
		almoxarifado = new Almoxarifado();
		tipoProduto = new TipoProduto();
	}
	
	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
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
