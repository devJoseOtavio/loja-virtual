import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import DAO.CategoriaDao;
import loja_process.ConnectionFactory;
import modelo.Categoria;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDao categoriaDao = new CategoriaDao(connection);
			List<Categoria> categoriaList = categoriaDao.listar();
			categoriaList.stream().forEach(ct -> System.out.println(ct.getNome()));
		}
	}

}
