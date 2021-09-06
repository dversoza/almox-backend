package dvtech.dev.almoxcontrol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dvtech.dev.almoxcontrol.exceptions.PessoaNotFoundException;
import dvtech.dev.almoxcontrol.models.Pessoa;
import dvtech.dev.almoxcontrol.repositories.PessoaRepository;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa addPessoa(Pessoa pessoa) {
        Optional<Pessoa> pessoaOptional = pessoaRepository
                .findPessoaByNome(pessoa.getNome());
        if (pessoaOptional.isPresent()) {
            throw new IllegalStateException(
                    "Já existe uma pessoa cadastrada com este nome!");
        } else {
            return pessoaRepository.save(pessoa);
        }
    }

    public void deletePessoa(Integer idPessoa) {
        if (!pessoaRepository.existsById(idPessoa)) {
            throw new IllegalStateException(
                    "Não existe uma pessoa cadastrada com o id " + idPessoa
                            + ".");
        } else {
            pessoaRepository.deleteById(idPessoa);
        }
    }

    public List<Pessoa> findAllPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa findPessoaById(Integer idPessoa) {
        return pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new PessoaNotFoundException(
                        "Pessoa não encontrada pelo id " + idPessoa));
    }

    public Pessoa updatePessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

}
