package br.com.projetobase.web;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetobase.dao.UsuarioDAO;
import br.com.projetobase.dao.hibernate.UsuarioHibernateDAO;
import br.com.projetobase.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean {

	@Inject
	private Usuario usuario;

	private String nomeUsuario;
	private String senha;
	
	private UsuarioHibernateDAO usuarioHibernateDAO;

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		this.usuarioHibernateDAO.buscarPorNome(this.nomeUsuario);
		
		if ("admin".equals(this.nomeUsuario) && "123".equals(this.senha)) {
			
			
			this.usuario.setNome(this.nomeUsuario);
			return "/ConsultaLancamentos?faces-redirect=true";
		} else {
			FacesMessage mensagem = new FacesMessage("Usuário/senha inválidos!");
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}

		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
