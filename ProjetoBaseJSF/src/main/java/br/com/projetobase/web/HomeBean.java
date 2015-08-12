package br.com.projetobase.web;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.projetobase.arq.util.DadosSessao;
import br.com.projetobase.modelo.Usuario;
import br.com.projetobase.web.service.UsuarioService;

@Named
@RequestScoped
public class HomeBean extends AbstractBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	@Inject
	private DadosSessao dadosSessao;

	public void testeHibernate() {

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String txtAnotherProperty = request.getParameter("dataInicio");
		String txtAnotherProperty2 = request.getParameter("dataFim");
		
		System.out.println(txtAnotherProperty);
		System.out.println(txtAnotherProperty2);
		
		

	}

	public String irParaLogin() {
		return navegacaoPaginas.getLogin().redirect().construir();
	}

	public String irParaCadastroEquipamento() {
		return navegacaoPaginas.getCadastrarEquipamento().redirect()
				.construir();
	}

	public String irParaCadastroSensor() {
		return navegacaoPaginas.getCadastrarSensor().redirect().construir();
	}

	public String irParaHome() {
		return navegacaoPaginas.getHome().redirect().construir();
	}

	public String irParaGerenciamentoUsuarios() {
		return navegacaoPaginas.getGerencioamentoUsuario().redirect()
				.construir();
	}

}
