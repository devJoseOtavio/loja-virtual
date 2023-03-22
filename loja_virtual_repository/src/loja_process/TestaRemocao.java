package loja_process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory cnf = new ConnectionFactory();
		Connection connection = cnf.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 3);
		stm.execute();
		
		Integer countDelete = stm.getUpdateCount();
		System.out.println("A quantidade de alterações é de: " + countDelete);
	}
}
