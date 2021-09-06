package dvtech.dev.almoxcontrol.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dvtech.dev.almoxcontrol.models.Pessoa;
import dvtech.dev.almoxcontrol.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        List<Pessoa> pessoas = pessoaService.findAllPessoas();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> getPessoaById(
            @PathVariable("idPessoa") Integer idPessoa) {
        Pessoa pessoa = pessoaService.findPessoaById(idPessoa);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
        Pessoa newPessoa = pessoaService.addPessoa(pessoa);
        return new ResponseEntity<>(newPessoa, HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<Pessoa> updatePessoa(@RequestBody Pessoa pessoa) {
        Pessoa updatedPessoa = pessoaService.updatePessoa(pessoa);
        return new ResponseEntity<>(updatedPessoa, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/excluir/{idPessoa}")
    public ResponseEntity<?> deletePessoa(
            @PathVariable("idPessoa") Integer idPessoa) {
        pessoaService.deletePessoa(idPessoa);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
