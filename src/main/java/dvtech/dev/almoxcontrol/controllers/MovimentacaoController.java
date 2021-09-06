package dvtech.dev.almoxcontrol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import dvtech.dev.almoxcontrol.models.Movimentacao;
import dvtech.dev.almoxcontrol.services.MovimentacaoService;

@RestController
@RequestMapping(path = "/movimentacoes")
public class MovimentacaoController {
    private final MovimentacaoService movimentacaoService;

    @Autowired
    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Movimentacao>> getAllMovimentacoes() {
        List<Movimentacao> movimentacoes = movimentacaoService
                .findAllMovimentacoes();
        return new ResponseEntity<>(movimentacoes, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Movimentacao> getMovimentacao(@PathVariable Long id) {
        Movimentacao movimentacao = movimentacaoService.findById(id);
        return new ResponseEntity<>(movimentacao, HttpStatus.OK);
    }

    @PostMapping(path = "/criar")
    public ResponseEntity<Movimentacao> createMovimentacao(
            @RequestBody Movimentacao movimentacao) {
        Movimentacao movimentacaoCriada = movimentacaoService
                .addMovimentacao(movimentacao);
        return new ResponseEntity<>(movimentacaoCriada, HttpStatus.CREATED);
    }

    @PutMapping(path = "/atualizar")
    public ResponseEntity<Movimentacao> updateMovimentacao(
            @RequestBody Movimentacao movimentacao) {
        Movimentacao movimentacaoAtualizada = movimentacaoService
                .updateMovimentacao(movimentacao);
        return new ResponseEntity<>(movimentacaoAtualizada, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(path = "/excluir/{id}")
    public ResponseEntity<Movimentacao> deleteMovimentacao(
            @PathVariable Long id) {
        movimentacaoService.deleteMovimentacao(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
