package loja_process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInserscaoParametro {
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {
			connection.setAutoCommit(false);
			try (PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUE (?, ?)", Statement.RETURN_GENERATED_KEYS);){
				adicionarVariavel("SMARTTV", "45 POLEGADAS", stm);
				adicionarVariavel("RADIO", "RADIO DE BATERIA", stm);
				
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback executado!");
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		try (ResultSet rst = stm.getGeneratedKeys()) {
			while(rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi " + id);
			}
		}
	}
}
