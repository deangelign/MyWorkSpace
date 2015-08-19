package br.com.logap.dao;



public interface DAO <T extends ModeloPersistencia> {
	void inserir(T entidade);
	
	void atualizar(T entidade);
	
	void remover(T entidade);
	
	T buscar(Long id);
	
}
