package dvtech.dev.almoxcontrol.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table
public class UnidadeMedida implements Serializable {
    @Id
    @SequenceGenerator(name = "unidade_medida_seq", sequenceName = "unidade_medida_seq", allocationSize = 1)
    @GeneratedValue(generator = "unidade_medida_seq", strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false, unique = true)
    private Integer id;
    private String nome;
    private String sigla;

    public UnidadeMedida() {
    }

    public UnidadeMedida(Integer id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public UnidadeMedida(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "UnidadeMedida {id=" + id + ", nome=" + nome + ", sigla=" + sigla
                + "}";
    }

}
