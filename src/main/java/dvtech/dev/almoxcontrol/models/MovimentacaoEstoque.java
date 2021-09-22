package dvtech.dev.almoxcontrol.models;

public class MovimentacaoEstoque {
    public String produto;
    public Integer quantidade;

    public MovimentacaoEstoque(String produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "MovimentacaoEstoque{" + "produto='" + produto + '\'' + ", quantidade=" + quantidade + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MovimentacaoEstoque that = (MovimentacaoEstoque) o;

        if (produto != null ? !produto.equals(that.produto) : that.produto != null)
            return false;
        return quantidade != null ? quantidade.equals(that.quantidade) : that.quantidade == null;
    }
}
