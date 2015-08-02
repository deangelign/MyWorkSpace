package br.com.projetobase.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;









import br.com.projetobase.dao.UsuarioDAO;
import br.com.projetobase.modelo.Usuario;
import br.com.projetobase.web.service.UsuarioService;

@Named
@javax.faces.view.ViewScoped
public class ManagerUserBean extends AbstractBean{
	
	private static final long serialVersionUID = 1L;
	
	private List<Usuario> usuarios;

	@Inject
	private Usuario usuario;
	
	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	public ManagerUserBean() {
	
	}
	
	public void cadastrar() {

		 usuarioService.salvar(usuario);
		 atualizarLista();
	}
	
	public String editAction(Usuario usuario){
		usuario.setEditable(true);
		return null;
	}
	
	public String deletarAction(Usuario usuario){
		usuarioService.deletar(usuario);
		atualizarLista();
		return null;
	}
	
	public void atualizarLista() {
		this.usuarios = usuarioDAO.buscarTodosUsuarios();			
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String salvarAlteracoesAction(){
		this.updateUsuarios();
		atualizarLista();
		return null;
	}

	public void updateUsuarios(){
		usuarioService.atualizarLista(usuarios);
	}
	
	

	

	

}
