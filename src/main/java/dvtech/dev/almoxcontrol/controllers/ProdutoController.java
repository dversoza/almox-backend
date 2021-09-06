package dvtech.dev.almoxcontrol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dvtech.dev.almoxcontrol.models.Produto;
import dvtech.dev.almoxcontrol.services.ProdutoService;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        List<Produto> produtos = produtoService.findAllProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(
            @PathVariable("id") Integer id) {
        Produto produto = produtoService.findProdutoById(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @PostMapping(path = "/criar")
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        Produto produtoCriado = produtoService.addProduto(produto);
        return new ResponseEntity<>(produtoCriado, HttpStatus.CREATED);
    }

    @PutMapping(path = "/atualizar")
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) {
        Produto produtoAtualizado = produtoService.updateProduto(produto);
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping(path = "/excluir/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable("id") Integer id) {
        produtoService.deleteProduto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
