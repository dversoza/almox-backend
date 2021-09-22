package dvtech.dev.almoxcontrol.models;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Barraca implements Serializable {
    @Id
    @SequenceGenerator(name = "barraca_seq", sequenceName = "barraca_seq", allocationSize = 1)
    @GeneratedValue(generator = "barraca_seq", strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false, unique = true)
    private Integer id;
    private String nome;
    private String contato;

    @ManyToOne(optional = true)
    @JoinColumn(name = "responsavel")
    @JsonIgnoreProperties(value = { "barraca" }, allowSetters = true)
    private Pessoa responsavel;

    public Barraca() {
    }

    public Barraca(Integer id, String nome, String contato, Pessoa responsavel) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
        this.responsavel = responsavel;
    }

    public Barraca(String nome, String contato, Pessoa responsavel) {
        this.nome = nome;
        this.contato = contato;
        this.responsavel = responsavel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Barraca {contato=" + contato + ", id=" + id + ", nome=" + nome + ", responsavel=" + responsavel + "}";
    }
}
