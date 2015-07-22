package br.com.projetobase.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetobase.modelo.Usuario;
import br.com.projetobase.web.service.UsuarioService;

@Named
@RequestScoped
public class CadastroUsuarioBean extends AbstractBean {

	@Inject
	private Usuario usuario;

	@Inject
	private UsuarioService usuarioService;

	public void cadastrar() {

		//System.out.println(this.usuario.getNome());
		//System.out.println(this.usuario.getSenha());
		//System.out.println(this.usuario.getEmail());
		//System.out.println(this.usuario.getConfirmarSenha());

		 usuarioService.salvar(usuario);
		 //System.out.println("pronto");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String irParaLogin() {
		return navegacaoPaginas.getLogin().redirect().construir();

	}

}
