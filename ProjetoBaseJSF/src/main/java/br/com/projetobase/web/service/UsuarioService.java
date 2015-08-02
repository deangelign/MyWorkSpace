package br.com.projetobase.web.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.projetobase.arq.dao.hibernate.interceptor.transaction.Transactional;
import br.com.projetobase.dao.UsuarioDAO;
import br.com.projetobase.modelo.Sensor;
import br.com.projetobase.modelo.Usuario;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Transactional
	public void salvar(Usuario usuario) {
		if (usuario.getId() != null && usuario.getId() != 0) {
			usuarioDAO.inserir(usuario);
		} else {
			usuarioDAO.atualizar(usuario);
		}
	}

	@Transactional
	public void deletar(Usuario usuario) {

		if (usuario.getId() != null && usuario.getId() != 0) {
			usuarioDAO.remover(usuario);
		}

	}

	@Transactional
	public void atualizarLista(List<Usuario> usuarios) {

		for (Usuario usuario : usuarios) {
			if (usuario.isEditable()) {
				usuario.setEditable(false);
				usuarioDAO.atualizar(usuario);
			}

		}

	}

}
