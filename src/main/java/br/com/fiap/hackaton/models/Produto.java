package br.com.fiap.hackaton.models;

public class Produto {
	private Integer id_produto;
	
	public Produto (Integer id_produto) {
		this.id_produto = id_produto;
	}
	
	public Integer getId_produto() {
		return id_produto;
	}
	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}
}
