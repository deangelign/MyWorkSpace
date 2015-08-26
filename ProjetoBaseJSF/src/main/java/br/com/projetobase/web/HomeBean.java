package br.com.projetobase.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.jboss.weld.context.RequestContext;

@Named
@RequestScoped
public class HomeBean extends AbstractBean {

	private static final long serialVersionUID = 1L;

	private String erroMessageDates;

	public void testeHibernate() {

		// HttpServletRequest request = (HttpServletRequest)
		// FacesContext.getCurrentInstance().getExternalContext().getRequest();
		// String txtAnotherProperty = request.getParameter("t1");
		// String txtAnotherProperty2 = request.getParameter("t2");

		// System.out.println(txtAnotherProperty);
		// System.out.println(txtAnotherProperty2);

		String dataInicio = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("tt1");

		String dataFim = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("tt2");
		
		Date dataComeco = new Date();
		Date dataFinal =  new Date();
		
		SimpleDateFormat sfm = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			dataComeco = sfm.parse(dataInicio);
			dataFinal = sfm.parse(dataFim);
			if(dataComeco.getTime() > dataFinal.getTime()){
				this.erroMessageDates = "Data inicial e maior que data final";
				FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("myForm:calendarMessage");
			}
			else{
				this.erroMessageDates = "";
				FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("myForm:calendarMessage");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

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

	public String getErroMessageDates() {
		return erroMessageDates;
	}

	public void setErroMessageDates(String erroMessageDates) {
		this.erroMessageDates = erroMessageDates;
	}

}
