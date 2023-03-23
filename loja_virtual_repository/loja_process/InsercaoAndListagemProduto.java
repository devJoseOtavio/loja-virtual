package loja_process;

import modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.ProdutoDao;

public class InsercaoAndListagemProduto {

	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("COMODA", "COMODA VERTICAL");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDao produto = new ProdutoDao(connection);
			produto.save(comoda);
			List<Produto> produtoList = produto.listar();
			produtoList.stream().forEach(lp -> System.out.println(lp));
		} 
	}
}
