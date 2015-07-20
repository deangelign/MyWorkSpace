package br.com.projetobase.web;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.projetobase.arq.util.DadosSessao;
import br.com.projetobase.dao.UsuarioDAO;
import br.com.projetobase.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean extends AbstractBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuario usuario;

	@Inject
	private UsuarioDAO usuarioHibernateDAO;
	
	@Inject
	private DadosSessao dadosSessao;

	public String login() {
		Usuario usuario = this.usuarioHibernateDAO.buscarPorEmail(this.usuario.getEmail());
		if (usuario != null) {
			if (this.usuario.getSenha().equals(usuario.getSenha())) {
				dadosSessao.adicionarUsuario(usuario);
				return navegacaoPaginas.getHome().redirect().construir();
			} else {
				gerenciadorDeMensagens.addMensagemErro(gerenciadorDeMensagens.getMensagem("usuario_incorreto"));
			}
		} 
		else {
			gerenciadorDeMensagens.addMensagemErro(gerenciadorDeMensagens.getMensagem("usuario_incorreto"));
		}

		return retornarMesmaPagina();
	}
	
	public String sair() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
		return navegacaoPaginas.getLogin().redirect().construir();
	}
	
	public String irParaCadastroPessoa(){
		return navegacaoPaginas.getCadastrarUsuario().redirect().construir();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
