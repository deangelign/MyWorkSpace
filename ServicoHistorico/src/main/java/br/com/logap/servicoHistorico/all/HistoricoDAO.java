package br.com.logap.servicoHistorico.all;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoricoDAO {

	private Connection connection;

	public HistoricoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionar(Historico historico) {
		String sql = "insert into historico " + "(id,valor,tempo,id_sensor)"
				+ " values (?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, historico.getId());
			stmt.setDouble(2, historico.getValor());
			stmt.setTimestamp(3, historico.getTempo());
			stmt.setLong(4, historico.getId_sensor());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remover(Historico historico) {
		String sql = "delete" + "from historico where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, historico.getId());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(Historico historico) {
		String sql = "update historico set valor=?, tempo=?, id_sensor=?, where id=?";
		

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setDouble(2, historico.getValor());
			stmt.setTimestamp(3, historico.getTempo());
			stmt.setLong(4, historico.getId_sensor());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Historico> ListarTodos() {
		String sql = "select * from historico";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet resultSet = stmt.executeQuery();
			List<Historico> historicos = new ArrayList<Historico>();

			while (resultSet.next()) {

				Historico historico = new Historico();
				historico.setId(resultSet.getLong("id"));
				historico.setValor(resultSet.getDouble("valor"));
				historico.setTempo(resultSet.getTimestamp("tempo"));
				historico.setId_sensor( resultSet.getLong("id_sensor") );

				historicos.add(historico);
			}

			resultSet.close();
			stmt.close();
			return historicos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
