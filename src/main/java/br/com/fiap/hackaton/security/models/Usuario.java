package br.com.fiap.hackaton.security.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    private Date dtDesativado;

    @ManyToMany
    @JoinTable(
            name = "perfilAcessoUsuario",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idPerfilAcesso")
    )
    private List<PerfilAcesso> perfisAcesso;

// getters e setters

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDtDesativado() {
        return dtDesativado;
    }

    public void setDtDesativado(Date dtDesativado) {
        this.dtDesativado = dtDesativado;
    }

    public List<PerfilAcesso> getPerfisAcesso() {
        return perfisAcesso;
    }

    public void setPerfisAcesso(List<PerfilAcesso> perfisAcesso) {
        this.perfisAcesso = perfisAcesso;
    }

    @Override
    public String toString() {
        return String.format(">> ID: '%s' | Nome: '%s' | dtDesativado: '%s' | Lista Perfils de acesso: '%s'<< ", id, username, dtDesativado, perfisAcesso);
    }
}
