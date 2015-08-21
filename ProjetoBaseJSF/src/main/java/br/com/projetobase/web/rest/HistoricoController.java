package br.com.projetobase.web.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	@Path("/buscarPontos")
	public List<Historico> buscarPontos(Parametros parametros) {
		SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd");
		List<Historico> dadosHistoricos = Collections.emptyList();
		try {
			dadosHistoricos = historicoHibernateDAO.buscarHistoricoDoGrafico(parametros.getId(), sfm.parse(parametros.getDataInicio()), sfm.parse(parametros.getDataFim()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(parametros.toString());
		
		return dadosHistoricos;
	}
	
}
