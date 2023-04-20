package br.com.fiap.hackaton.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@JoinColumn(name="id_cliente")
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	
	@OneToMany(mappedBy="reclamacao")
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	public List<Atendimento> getHistorico_atendimento() {
		return historico_atendimento;
	}
	public void setHistorico_atendimento(List<Atendimento> historico_atendimento) {
		this.historico_atendimento = historico_atendimento;
	}
}
