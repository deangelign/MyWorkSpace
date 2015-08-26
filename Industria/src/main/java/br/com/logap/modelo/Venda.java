package br.com.logap.modelo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.logap.dao.ModeloPersistencia;

@Entity
@Table(name = "venda")
public class Venda extends ModeloPersistencia{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_vendedor")
	private Vendedor vendedor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "id_entrega")
	private Entrega entrega;
	
	@Transient
	boolean editable;
	
	public Venda(){
		cliente = new Cliente();
		vendedor = new Vendedor();
		entrega = new Entrega();
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	
	
}
