package modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private Integer id;
	
	private String nome;
	
	private List<Produto> produtoList = new ArrayList<Produto>();
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void adicionaProduto(Produto produto) {
		produtoList.add(produto);
	}
	
	public List<Produto> getProduto() {
		return produtoList;
	}
}
