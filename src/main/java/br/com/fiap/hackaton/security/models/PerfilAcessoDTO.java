package br.com.fiap.hackaton.security.models;

import org.springframework.security.core.GrantedAuthority;

public class PerfilAcessoDTO implements GrantedAuthority {

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    private String codigo;


    public PerfilAcessoDTO() {}
    public PerfilAcessoDTO(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getAuthority() { return getCodigo(); }

    @Override
    public String toString() {
        return String.format("Perfil de Acesso: '%s' ", codigo);
    }
}
