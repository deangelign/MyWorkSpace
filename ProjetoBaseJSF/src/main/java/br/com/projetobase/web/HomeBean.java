package br.com.projetobase.web;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class HomeBean extends AbstractBean {

	private static final long serialVersionUID = 1L;

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
