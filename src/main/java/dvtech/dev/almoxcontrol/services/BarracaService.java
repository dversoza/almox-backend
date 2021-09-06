package dvtech.dev.almoxcontrol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dvtech.dev.almoxcontrol.exceptions.BarracaNotFoundException;
import dvtech.dev.almoxcontrol.models.Barraca;
import dvtech.dev.almoxcontrol.repositories.BarracaRepository;

@Service
public class BarracaService {
    private final BarracaRepository barracaRepository;

    @Autowired
    public BarracaService(BarracaRepository barracaRepo) {
        this.barracaRepository = barracaRepo;
    }

    public Barraca addBarraca(Barraca barraca) {
        Optional<Barraca> barracaOptional = barracaRepository
                .findBarracaByNome(barraca.getNome());
        if (barracaOptional.isPresent()) {
            throw new IllegalStateException("A barraca '" + barraca.getNome()
                    + "' já existe e está cadastrada com o id "
                    + barracaOptional.get().getId() + ".");
        } else {
            return barracaRepository.save(barraca);
        }
    }

    public List<Barraca> findAllBarracas() {
        return barracaRepository.findAll();
    }

    public Barraca updateBarraca(Barraca barraca) {
        return barracaRepository.save(barraca);
    }

    public void deleteBarraca(Integer idBarraca) {
        if (!barracaRepository.existsById(idBarraca)) {
            throw new IllegalStateException(
                    "Não existe uma barraca com o id " + idBarraca + ".");
        } else {
            barracaRepository.deleteById(idBarraca);
        }
    }

    public Barraca findBarracaById(Integer idBarraca) {
        return barracaRepository.findById(idBarraca)
                .orElseThrow(() -> new BarracaNotFoundException(
                        "Barraca não encontrada pelo id" + idBarraca));
    }
}
