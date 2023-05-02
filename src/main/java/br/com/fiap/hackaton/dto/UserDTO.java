package br.com.fiap.hackaton.dto;

import java.sql.Date;

public class UserDTO {
    private Integer id;
    private String username;

    private Date dtDesativado;

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
}
