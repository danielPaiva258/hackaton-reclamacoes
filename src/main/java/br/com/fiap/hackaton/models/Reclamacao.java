package br.com.fiap.hackaton.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reclamacao")
public class Reclamacao {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data_criacao;
	private String titulo;
	private String origem;
	private String status;
	private String cliente;
	private List<Atendimento> historico_atendimento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Calendar getData_criacao() {
		return data_criacao;
	}
	public void setData_criacao(Calendar data_criacao) {
		this.data_criacao = data_criacao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public List<Atendimento> getHistorico_atendimento() {
		return historico_atendimento;
	}
	public void setHistorico_atendimento(List<Atendimento> historico_atendimento) {
		this.historico_atendimento = historico_atendimento;
	}
}
