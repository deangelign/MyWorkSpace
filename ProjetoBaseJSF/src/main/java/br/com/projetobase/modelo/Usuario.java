package br.com.projetobase.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.projetobase.arq.modelo.ModeloPersistencia;

/**
 * Classe que representa o usuário do sistema.
 * 
 * @author danilo-barros
 *
 */
@Entity
@Table(name = "usuario")
public class Usuario extends ModeloPersistencia {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Column(name = "nome", nullable = false)
	private String nome;

	@NotEmpty
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@NotEmpty
	@Column(name = "senha")
	private String senha;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Equipamento> equipamentos;
	
	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	@Transient
	private String confirmarSenha;

	@Transient
	private boolean Logado;
	
	public boolean isLogado() {
		return Logado;
	}

	public void setLogado(boolean logado) {
		Logado = logado;
	}

	public Usuario() {
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	public String toString(){
		 
		return this.nome + " ; " + this.email + " ; " + this.senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	
	

}