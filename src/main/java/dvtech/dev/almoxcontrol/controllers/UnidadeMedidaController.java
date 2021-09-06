package dvtech.dev.almoxcontrol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dvtech.dev.almoxcontrol.models.UnidadeMedida;
import dvtech.dev.almoxcontrol.services.UnidadeMedidaService;

@RestController
@RequestMapping(value = "/um")
public class UnidadeMedidaController {
    private final UnidadeMedidaService umService;

    @Autowired
    public UnidadeMedidaController(UnidadeMedidaService umService) {
        this.umService = umService;
    }

    @GetMapping
    public ResponseEntity<List<UnidadeMedida>> getAllUnidadesMedidas() {
        List<UnidadeMedida> umList = umService.findAllUnidadesMedidas();
        return new ResponseEntity<>(umList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UnidadeMedida> getUnidadeMedidaById(
            @PathVariable("id") Integer id) {
        UnidadeMedida um = umService.findUnidadeMedidaById(id);
        return new ResponseEntity<>(um, HttpStatus.OK);
    }

    @PostMapping(path = "/criar")
    public ResponseEntity<UnidadeMedida> createUnidadeMedida(
            @RequestBody UnidadeMedida um) {
        UnidadeMedida umCreated = umService.addUnidadeMedida(um);
        return new ResponseEntity<>(umCreated, HttpStatus.CREATED);
    }

    @PutMapping(path = "/atualizar")
    public ResponseEntity<UnidadeMedida> updateUnidadeMedida(
            @RequestBody UnidadeMedida um) {
        UnidadeMedida umUpdated = umService.updateUnidadeMedida(um);
        return new ResponseEntity<>(umUpdated, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(path = "/excluir/{id}")
    public ResponseEntity<?> deleteUnidadeMedida(
            @PathVariable("id") Integer id) {
        umService.deleteUnidadeMedida(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
