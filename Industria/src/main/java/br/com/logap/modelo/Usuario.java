package br.com.logap.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends PessoaFisica{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="login",nullable=false)
	private String login;
	
	@Column(name="senha",nullable=false)
	private String senha;
	
	

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
	
	
	

}
