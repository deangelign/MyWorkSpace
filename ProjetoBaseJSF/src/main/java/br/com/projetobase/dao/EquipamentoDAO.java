package br.com.projetobase.dao;

import java.util.List;

import br.com.projetobase.arq.dao.DAO;
import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.modelo.Usuario;


public interface EquipamentoDAO extends DAO<Equipamento> {
	boolean cadastrarEquipamento(Usuario usuario);
	Equipamento buscarPorNome(String nome);
	List<Equipamento> buscarEquipamentosUsuario(long usuario_id);
}

