package dvtech.dev.almoxcontrol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dvtech.dev.almoxcontrol.models.Produto;
import dvtech.dev.almoxcontrol.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto addProduto(Produto produto) {
        Optional<Produto> produtoOptional = produtoRepository
                .findProdutoByNome(produto.getNome());
        if (produtoOptional.isPresent()) {
            throw new IllegalArgumentException("Produto já cadastrado");
        } else {
            return produtoRepository.save(produto);
        }
    }

    public Produto updateProduto(Produto produto) {
        Optional<Produto> produtoOptional = produtoRepository
                .findById(produto.getId());
        if (produtoOptional.isPresent()) {
            return produtoRepository.save(produto);
        } else {
            throw new IllegalArgumentException("Produto não encontrado");
        }
    }

    public void deleteProduto(Integer id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            produtoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Produto não encontrado");
        }
    }

    public Produto findProdutoById(Integer id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            return produtoOptional.get();
        } else {
            throw new IllegalArgumentException("Produto não encontrado");
        }
    }

    public List<Produto> findAllProdutos() {
        return produtoRepository.findAll();
    }
}
