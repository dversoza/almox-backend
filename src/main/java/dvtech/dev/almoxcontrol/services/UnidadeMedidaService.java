package dvtech.dev.almoxcontrol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dvtech.dev.almoxcontrol.models.UnidadeMedida;
import dvtech.dev.almoxcontrol.repositories.UnidadeMedidaRepository;

@Service
public class UnidadeMedidaService {
    private final UnidadeMedidaRepository umRepository;

    @Autowired
    public UnidadeMedidaService(UnidadeMedidaRepository umRepository) {
        this.umRepository = umRepository;
    }

    public UnidadeMedida addUnidadeMedida(UnidadeMedida um) {
        Optional<UnidadeMedida> umOptional = umRepository
                .findUnidadeMedidaByNome(um.getNome());
        if (umOptional.isPresent()) {
            throw new IllegalArgumentException("Unidade de Medida já existe!");
        } else {
            return umRepository.save(um);
        }
    }

    public UnidadeMedida updateUnidadeMedida(UnidadeMedida um) {
        Optional<UnidadeMedida> umOptional = umRepository
                .findUnidadeMedidaById(um.getId());
        if (umOptional.isPresent()) {
            return umRepository.save(um);
        } else {
            throw new IllegalArgumentException(
                    "Unidade de Medida não localizada!");
        }
    }

    public void deleteUnidadeMedida(Integer id) {
        Optional<UnidadeMedida> umOptional = umRepository.findById(id);
        if (umOptional.isPresent()) {
            umRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException(
                    "Unidade de Medida não encontrada!");
        }
    }

    public List<UnidadeMedida> findAllUnidadesMedidas() {
        return umRepository.findAll();
    }

    public UnidadeMedida findUnidadeMedidaById(Integer id) {
        Optional<UnidadeMedida> umOptional = umRepository
                .findUnidadeMedidaById(id);
        if (umOptional.isPresent()) {
            return umOptional.get();
        } else {
            throw new IllegalArgumentException(
                    "Unidade de Medida não encontrada!");
        }
    }

}
