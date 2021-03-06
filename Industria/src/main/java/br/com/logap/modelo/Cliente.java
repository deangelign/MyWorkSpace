package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="cliente")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cliente extends Usuario{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="numero_cartao",nullable=false)
	private String numeroCartao;
	
	@Transient
	boolean editable;
	
	public Cliente(){}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
	public void  update(Usuario usuario){
		setNome(usuario.getNome());
		setCpf(usuario.getCpf());
		setEmail(usuario.getEmail());
		setEndereco(usuario.getEndereco());
		setIdade(usuario.getIdade());
		setLogin(usuario.getLogin());
		//setRG(usuario.getRG());
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