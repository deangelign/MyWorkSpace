package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "vendedor")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vendedor extends Usuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "numero_vendedor", nullable = false)
	private int numeroVendedor;
	
	@Transient
	boolean editable;

	public Vendedor() {
	}

	public int getNumeroVendedor() {
		return numeroVendedor;
	}

	public void setNumeroVendedor(int numeroVendedor) {
		this.numeroVendedor = numeroVendedor;
	}

	public void update(Usuario usuario) {
		setNome(usuario.getNome());
		setCpf(usuario.getCpf());
		setEmail(usuario.getEmail());
		setEndereco(usuario.getEndereco());
		setIdade(usuario.getIdade());
		setLogin(usuario.getLogin());
		// setRG(usuario.getRG());
		setSenha(usuario.getSenha());
		setSexo(usuario.getSexo());
		setTelefone(usuario.getTelefone());
		setTipoUsuario(usuario.getTipoUsuario());
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	
}