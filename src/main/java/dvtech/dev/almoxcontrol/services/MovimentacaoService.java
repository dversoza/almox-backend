package dvtech.dev.almoxcontrol.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dvtech.dev.almoxcontrol.models.Barraca;
import dvtech.dev.almoxcontrol.models.Movimentacao;
import dvtech.dev.almoxcontrol.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {
    private final MovimentacaoRepository movimentacaoRepository;

    @Autowired
    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public Movimentacao addMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public Movimentacao updateMovimentacao(Movimentacao movimentacao) {
        Optional<Movimentacao> opt = movimentacaoRepository
                .findById(movimentacao.getId());
        if (opt.isPresent()) {
            return movimentacaoRepository.save(movimentacao);
        } else {
            throw new IllegalArgumentException("Movimentação não encontrada!");
        }
    }

    public void deleteMovimentacao(Long id) {
        Optional<Movimentacao> opt = movimentacaoRepository.findById(id);
        if (opt.isPresent()) {
            movimentacaoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Movimentação não encontrada!");
        }
    }

    public Movimentacao findById(Long id) {
        Optional<Movimentacao> opt = movimentacaoRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new IllegalArgumentException("Movimentação não encontrada!");
        }
    }

    public List<Movimentacao> findAllMovimentacoes() {
        return movimentacaoRepository.findAll();
    }

    public List<Movimentacao> findMovimentacaoByBarraca(Barraca barraca) {
        return movimentacaoRepository.findMovimentacoesByBarraca(barraca)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Nenhuma movimentação encontrada!"));
    }

    public List<Movimentacao> findMovimentacaoByDataFato(Date dataFato) {
        return movimentacaoRepository.findMovimentacoesByDataFato(dataFato)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Nenhuma movimentação encontrada!"));
    }
}
