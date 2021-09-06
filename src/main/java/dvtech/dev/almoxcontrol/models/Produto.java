package dvtech.dev.almoxcontrol.models;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.data.annotation.ReadOnlyProperty;

@Entity
@Table
public class Produto implements Serializable {
    @Id
    @SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", allocationSize = 1)
    @GeneratedValue(generator = "produto_seq", strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false, unique = true)
    private Integer id;
    private String nome;
    private String descricao;
    private String imagemURL;

    @ManyToOne
    @JoinColumn
    private UnidadeMedida unidadeMedida;

    // Estoque do produto
    @ReadOnlyProperty
    private Integer estoque;

    public Produto() {
    }

    public Produto(String nome, String descricao, String imagemURL,
            UnidadeMedida unidadeMedida) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagemURL = imagemURL;
        this.unidadeMedida = unidadeMedida;
    }

    public Produto(Integer id, String nome, String descricao, String imagemURL,
            UnidadeMedida unidadeMedida) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagemURL = imagemURL;
        this.unidadeMedida = unidadeMedida;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemURL() {
        return imagemURL;
    }

    public void setImagemURL(String imagemURL) {
        this.imagemURL = imagemURL;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    @Override
    public String toString() {
        return "Produto {descricao=" + descricao + ", id=" + id + ", imagemURL="
                + imagemURL + ", nome=" + nome + ", unidadeMedida="
                + unidadeMedida + "}";
    }

}
