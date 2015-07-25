package br.com.projetobase.arq.util;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.projetobase.modelo.Usuario;

@Named
@SessionScoped
public class DadosSessao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public DadosSessao() {
	}

	public Usuario getUsuarioDaSessao() {
		return usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void adicionarUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
