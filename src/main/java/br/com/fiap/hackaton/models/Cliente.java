package br.com.fiap.hackaton.models;

import java.util.List;

public class Cliente {
	
	private Integer id;
	private String nome;
	private String endereco;
	private List<Pedido> pedidos;
	private List<Reclamacao> reclamacoes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public List<Reclamacao> getReclamacoes() {
		return reclamacoes;
	}
	public void setReclamacoes(List<Reclamacao> reclamacoes) {
		this.reclamacoes = reclamacoes;
	}
}
