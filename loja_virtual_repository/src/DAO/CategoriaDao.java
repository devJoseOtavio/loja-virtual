package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Produto;

public class CategoriaDao {

	private Connection connection;
	
	public CategoriaDao(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> listar() throws SQLException {
		Categoria ultimo = null;
		List<Categoria> categorias = new ArrayList<>();
		
		String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN" + " PRODUTO P ON C.ID = P.CATEGORIA_ID";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					if (ultimo == null || ultimo.getNome().equals(rst.getString(2))) {
						Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
						ultimo = categoria;
						categorias.add(categoria);
					}
					Produto produto = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
					ultimo.adicionaProduto(produto);
				}
			}
		}
		return categorias;
	}

}
