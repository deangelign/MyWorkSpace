package br.com.projetobase.web.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.projetobase.dao.hibernate.HistoricoHibernateDAO;
import br.com.projetobase.modelo.Historico;
import br.com.projetobase.web.rest.dominio.Parametros;

@RequestScoped
@Path("/historico")
public class HistoricoController {

	@Inject
	private HistoricoHibernateDAO historicoHibernateDAO;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarPontos")
	public List<Historico> buscarPontos(Parametros parametros) {
		List<Historico> dadosHistoricos = historicoHibernateDAO.buscarHistoricoDoGrafico(parametros.getId(), parametros.getDataInicio(), parametros.getDataFim());
		System.out.println(parametros.toString());
		
		return dadosHistoricos;
	}
	
}
