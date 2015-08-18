package br.com.projetobase.web.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.projetobase.dao.hibernate.HistoricoHibernateDAO;
import br.com.projetobase.modelo.Historico;

@RequestScoped
@Path("/historico")
public class HistoricoController {

	@Inject
	private HistoricoHibernateDAO historicoHibernateDAO;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/buscarPontos")
	public List<Historico> buscarPontos(Long idSensor, String dataInicial, String dataFinal) {
		List<Historico> dadosHistoricos = historicoHibernateDAO.buscarHistoricoDoGrafico(idSensor, dataInicial, dataFinal);
		return dadosHistoricos;
	}
	
	@POST
    @Path("/buscarPontos2")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response buscarPontos2(String data){
		String result = "Data post: "+data;
		System.out.println(data);
		return Response.status(201).entity(result).build();
	}
	
	
	@POST
    @Path("/buscarPontos3")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response buscarPontos3(Object object){
		String result = "Data post: "+ object.toString();
		System.out.println(object);
		return Response.status(201).entity(result).build();
	}
	
	@POST
    @Path("/buscarPontos4")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public StatusBean buscarPontos4(StatusBean sb){
		System.out.println("ei caba safado, ta indo aonde?");
		System.out.println(sb);
		return sb;
	}
	
	
	@POST
    @Path("/buscarPontos5")
	public void buscarPontos5(){
		System.out.println("miau12345");
		
	}
	
	
	
	@POST
    @Path("/buscarPontos6")
	@Produces(MediaType.APPLICATION_JSON)
	public StatusBean buscarPontos6(){
		StatusBean sb = new StatusBean();
		sb.setName("em busca da perfeicao");
		return sb;
	}
	
	
}
