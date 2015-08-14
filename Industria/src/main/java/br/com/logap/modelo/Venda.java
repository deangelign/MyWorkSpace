package br.com.logap.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_vendedor")
	private Vendedor vendedor;
	
	@Column(name = "id_cliente", nullable = false)
	private long idCliente;
	
	@Column(name = "id_entrega", nullable = false)
	private long idEntrega;
	
	@Column(name = "valor", nullable = false)
	private long valorTotal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public long getIdEntrega() {
		return idEntrega;
	}

	public void setIdEntrega(long idEntrega) {
		this.idEntrega = idEntrega;
	}

	public long getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(long valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	
	
	
	
}
