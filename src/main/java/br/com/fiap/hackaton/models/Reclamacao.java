package br.com.fiap.hackaton.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="reclamacao")
public class Reclamacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao")
	@JsonProperty("data_criacao")
	private Calendar dataCriacao;
	private String titulo;
	private String origem;
	private String status;
	
	@Column(name="id_cliente")
	private Integer idCliente;
	
	@Transient
	private List<AtendimentoDTO> historico_atendimento;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
	public List<AtendimentoDTO> getHistorico_atendimento() {
		return historico_atendimento;
	}
	public void setHistorico_atendimento(List<AtendimentoDTO> historico_atendimento) {
		this.historico_atendimento = historico_atendimento;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}
