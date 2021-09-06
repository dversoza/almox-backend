package dvtech.dev.almoxcontrol.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table
public class Usuario implements Serializable {
    @Id
    @SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1)
    @GeneratedValue(generator = "usuario_seq", strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false, unique = true)
    private Integer id;
    private boolean ativo;
    private boolean admin;

    @ManyToOne
    private Pessoa pessoa;
    private String login;
    private String senha;

    public Usuario(Integer id, boolean ativo, boolean admin, Pessoa pessoa,
            String login, String senha) {
        this.id = id;
        this.ativo = ativo;
        this.admin = admin;
        this.pessoa = pessoa;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(boolean ativo, boolean admin, Pessoa pessoa, String login,
            String senha) {
        this.ativo = ativo;
        this.admin = admin;
        this.pessoa = pessoa;
        this.login = login;
        this.senha = senha;
    }

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario {admin=" + admin + ", ativo=" + ativo + ", id=" + id
                + ", login=" + login + ", pessoa=" + pessoa + ", senha=" + senha
                + "}";
    }

}
