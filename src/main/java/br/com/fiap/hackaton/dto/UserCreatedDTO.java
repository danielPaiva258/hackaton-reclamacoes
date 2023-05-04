package br.com.fiap.hackaton.dto;

import br.com.fiap.hackaton.models.PerfilAcesso;

import java.sql.Date;
import java.util.List;

public class UserCreatedDTO {
    private Integer id;
    private String username;

    private Date dtDesativado;

    List<String> perfilAcessoList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDtDesativado() {
        return dtDesativado;
    }

    public void setDtDesativado(Date dtDesativado) {
        this.dtDesativado = dtDesativado;
    }

    public List<String> getPerfilAcessoList() { return perfilAcessoList; }

    public void setPerfilAcessoList(List<String> perfilAcessoList) { this.perfilAcessoList = perfilAcessoList; }
}
