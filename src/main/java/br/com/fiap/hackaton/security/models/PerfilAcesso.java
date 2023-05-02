package br.com.fiap.hackaton.security.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table
public class PerfilAcesso implements GrantedAuthority {

    public static String ACESSO_ADMINISTRADOR = "ADMIN";
    public static String ACESSO_SUPERVISOR_ATENDIMENTO = "SUP-ATENDIMENTO";
    public static String ACESSO_ATENDENTE = "ATENDENTE";
    public static String ACESSO_CLIENTE = "CLIENTE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String codigo;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private Date dtDesativado;

    @ManyToMany(mappedBy = "perfisAcesso")
    private List<Usuario> usuarios;

    @Override
    public String getAuthority() { return getCodigo(); }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtDesativado() {
        return dtDesativado;
    }

    public void setDtDesativado(Date dtDesativado) {
        this.dtDesativado = dtDesativado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return String.format("Perfil de Acesso: '%s' ", codigo);
    }
}
