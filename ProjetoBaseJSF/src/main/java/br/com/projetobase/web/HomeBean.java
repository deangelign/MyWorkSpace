package br.com.projetobase.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
		
	}
	
	
	public String irParaLogin() {
		return navegacaoPaginas.getLogin().redirect().construir();
	}
	
	public String irParaCadastroEquipamento(){
		return navegacaoPaginas.getCadastrarEquipamento().redirect().construir();
	}
	
	public String irParaCadastroSensor(){
		return navegacaoPaginas.getCadastrarSensor().redirect().construir();
	}
	
	public String irParaHome(){
		return navegacaoPaginas.getHome().redirect().construir();
	}

	public String irParaGerenciamentoUsuarios() {
		return navegacaoPaginas.getGerencioamentoUsuario().redirect().construir();
	}


	
	
	
	

	
	
}
