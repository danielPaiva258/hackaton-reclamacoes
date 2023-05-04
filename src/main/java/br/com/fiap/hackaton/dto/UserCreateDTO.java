package br.com.fiap.hackaton.dto;

import java.util.List;

public class UserCreateDTO {
    private String username;
    private String password;

    private List<String> listaPerfilAcesso;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getListaPerfilAcesso() { return listaPerfilAcesso; }

    public void setListaPerfilAcesso(List<String> listaPerfilAcesso) { this.listaPerfilAcesso = listaPerfilAcesso; }
}
