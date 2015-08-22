package br.com.logap.controlador;

import br.com.logap.dao.UsuarioDAO;
import br.com.logap.modelo.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

	private Usuario usuario;
	
	private String login;
	private String senha;
	
	public LoginBean() {		
		usuario = new Usuario();
	}
	
	public void acharUsuarios(){
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String logar() {	
		return validarUsuario(login, senha);			
	}

	public String validarUsuario(String login, String senha) {
		String usuarioTeste = "teste";
		UsuarioDAO dao = new UsuarioDAO();
		String senhaTeste= dao.acharPorLogin(login);
		//String senhaTeste = "1234";

	//	if ((login.equals(usuarioTeste)) && (senha.equals(senhaTeste))){
		if ((senha.equals(senhaTeste))){			
			return "home";
		}else{
			return "login";
		}
	}
	
	public String logout(){
		return "login";				
	}
}