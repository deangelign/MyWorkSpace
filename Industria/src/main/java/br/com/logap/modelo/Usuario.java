package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="usuario")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends PessoaFisica{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="login",nullable=false, unique=true)
	private String login;
	
	@Column(name="senha",nullable=false)
	private String senha;
	
	@Column(name="tipoUsuario", nullable=false)
	private char tipoUsuario;
	
	

	public Usuario() {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public char getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(char tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public void update(Cliente cliente){
		setNome(cliente.getNome());
		setCpf(cliente.getCpf());
		setEmail(cliente.getEmail());
		setEndereco(cliente.getEndereco());
		setIdade(cliente.getIdade());
		setLogin(cliente.getLogin());
		//setRG(cliente.getRG());
		setSenha(cliente.getSenha());
		setSexo(cliente.getSexo());
		setTelefone(cliente.getTelefone());
		setTipoUsuario(cliente.getTipoUsuario());
	}
	
	
	
	
	
	

}
