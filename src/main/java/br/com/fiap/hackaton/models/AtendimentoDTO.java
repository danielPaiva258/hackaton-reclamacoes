package br.com.fiap.hackaton.models;

public class AtendimentoDTO {
    private Integer id;

    public AtendimentoDTO(Integer idAtendimento) { this.id = idAtendimento; }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

}
