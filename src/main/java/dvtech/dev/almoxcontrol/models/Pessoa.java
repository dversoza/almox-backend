package dvtech.dev.almoxcontrol.models;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Pessoa implements Serializable {
    @Id
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @Column(nullable = false, updatable = false, unique = true)
    private Integer id;
    private String nome;
    private Boolean pessoaJuridica;
    private String documento;
    private String telefone;

    @ManyToOne(optional = true)
    @JoinColumn(name = "barraca")
    @JsonIgnoreProperties(value = { "responsavel" }, allowSetters = true)
    private Barraca barraca;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, Boolean pessoaJuridica,
            String documento, String telefone, Barraca barraca) {
        this.id = id;
        this.nome = nome;
        this.pessoaJuridica = pessoaJuridica;
        this.documento = documento;
        this.telefone = telefone;
        this.barraca = barraca;
    }

    public Pessoa(String nome, Boolean pessoaJuridica, String documento,
            String telefone, Barraca barraca) {
        this.nome = nome;
        this.pessoaJuridica = pessoaJuridica;
        this.documento = documento;
        this.telefone = telefone;
        this.barraca = barraca;
    }

    public Pessoa(Integer id, String nome, Boolean pessoaJuridica,
            String documento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.pessoaJuridica = pessoaJuridica;
        this.documento = documento;
        this.telefone = telefone;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getPessoaJuridica() {
        return this.pessoaJuridica;
    }

    public void setPessoaJuridica(Boolean pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Barraca getBarraca() {
        return this.barraca;
    }

    public void setBarraca(Barraca barraca) {
        this.barraca = barraca;
    }

    @Override
    public String toString() {
        return "Pessoa [barraca=" + barraca + ", documento=" + documento
                + ", id=" + id + ", nome=" + nome + ", pessoaJuridica="
                + pessoaJuridica + ", telefone=" + telefone + "]";
    }

}
