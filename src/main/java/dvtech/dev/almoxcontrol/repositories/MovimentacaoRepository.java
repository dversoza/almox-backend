package dvtech.dev.almoxcontrol.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dvtech.dev.almoxcontrol.models.Barraca;
import dvtech.dev.almoxcontrol.models.Movimentacao;

@Repository
public interface MovimentacaoRepository
                extends JpaRepository<Movimentacao, Long> {

        Optional<List<Movimentacao>> findMovimentacoesByBarraca(
                        Barraca barraca);

        Optional<List<Movimentacao>> findMovimentacoesByDataFato(Date dataFato);

}
