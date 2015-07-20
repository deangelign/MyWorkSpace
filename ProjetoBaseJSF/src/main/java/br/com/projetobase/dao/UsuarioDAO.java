package br.com.projetobase.dao;

import br.com.projetobase.arq.dao.DAO;
import br.com.projetobase.modelo.Usuario;

public interface UsuarioDAO extends DAO<Usuario> {
	
	Usuario buscarPorEmail(String nome);
	boolean cadastrarUsuario(Usuario usuario);
}
