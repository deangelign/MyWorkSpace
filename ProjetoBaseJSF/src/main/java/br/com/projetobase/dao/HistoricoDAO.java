package br.com.projetobase.dao;

import java.util.List;

import br.com.projetobase.arq.dao.DAO;
import br.com.projetobase.modelo.Historico;

public interface HistoricoDAO extends DAO<Historico> {
	List<Historico> buscarHistoricoDoGrafico(Long idSensor,
			String dataInicial, String dataFinal);
}
