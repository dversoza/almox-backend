package dvtech.dev.almoxcontrol.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dvtech.dev.almoxcontrol.models.UnidadeMedida;

@Repository
public interface UnidadeMedidaRepository
        extends JpaRepository<UnidadeMedida, Integer> {
    Optional<UnidadeMedida> findUnidadeMedidaByNome(String nome);

    Optional<UnidadeMedida> findUnidadeMedidaById(Integer id);

}
