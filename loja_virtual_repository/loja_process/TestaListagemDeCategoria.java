package loja_process;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import DAO.CategoriaDao;
import modelo.Categoria;
import modelo.Produto;

public class TestaListagemDeCategoria {

	public static void main(String[] args) throws SQLException { 
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDao ctg = new CategoriaDao(connection);
			List<Categoria> categoriaList = ctg.listar();
			categoriaList.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				for (Produto produto :ct.getProduto()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}
			});
			
		};

	}

}
