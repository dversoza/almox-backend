package dvtech.dev.almoxcontrol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import dvtech.dev.almoxcontrol.services.BarracaService;
import dvtech.dev.almoxcontrol.models.Barraca;

@RestController
@RequestMapping(path = "/barracas")
public class BarracaController {
    private final BarracaService barracaService;

    @Autowired
    public BarracaController(BarracaService barracaService) {
        this.barracaService = barracaService;
    }

    @GetMapping
    public ResponseEntity<List<Barraca>> getAllBarracas() {
        List<Barraca> barracas = barracaService.findAllBarracas();
        return new ResponseEntity<>(barracas, HttpStatus.OK);
    }

    @GetMapping("/{idBarraca}")
    public ResponseEntity<Barraca> getBarracaByIdBarraca(
            @PathVariable("idBarraca") Integer idBarraca) {
        Barraca barraca = barracaService.findBarracaById(idBarraca);
        return new ResponseEntity<>(barraca, HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<Barraca> addBarraca(@RequestBody Barraca barraca) {
        Barraca newBarraca = barracaService.addBarraca(barraca);
        return new ResponseEntity<>(newBarraca, HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<Barraca> updateBarraca(@RequestBody Barraca barraca) {
        Barraca updatedBarraca = barracaService.updateBarraca(barraca);
        return new ResponseEntity<>(updatedBarraca, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(path = "/excluir/{idBarraca}")
    public ResponseEntity<?> deleteBarraca(
            @PathVariable("idBarraca") Integer idBarraca) {
        barracaService.deleteBarraca(idBarraca);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
