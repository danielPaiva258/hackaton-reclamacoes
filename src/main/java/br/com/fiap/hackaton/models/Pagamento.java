package br.com.fiap.hackaton.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pagamento")
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer pedido_id;
	private Double valor;
	private Double valor_frete;
	private Double valor_parcela;
	private Double forma_pagamento;
	
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getValor_frete() {
		return valor_frete;
	}
	public void setValor_frete(Double valor_frete) {
		this.valor_frete = valor_frete;
	}
	public Double getValor_parcela() {
		return valor_parcela;
	}
	public void setValor_parcela(Double valor_parcela) {
		this.valor_parcela = valor_parcela;
	}
	public Double getForma_pagamento() {
		return forma_pagamento;
	}
	public void setForma_pagamento(Double forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPedido_id() { return pedido_id;	}
	public void setPedido_id(Integer pedido_id) { this.pedido_id = pedido_id; }
}
