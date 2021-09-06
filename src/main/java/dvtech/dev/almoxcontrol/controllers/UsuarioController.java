package dvtech.dev.almoxcontrol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dvtech.dev.almoxcontrol.models.Usuario;
import dvtech.dev.almoxcontrol.services.UsuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> getUsuario(@RequestParam("id") Integer id) {
        Usuario usuario = usuarioService.findUsuarioById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping(path = "/{login}")
    public ResponseEntity<Usuario> getUsuarioByLogin(
            @RequestParam("login") String login) {
        Usuario usuario = usuarioService.findUsuarioByLogin(login);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping(path = "/criar")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario created = usuarioService.addUsuario(usuario);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping(path = "/atualizar")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        Usuario updated = usuarioService.updateUsuario(usuario);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(path = "/excluir/{id}")
    public ResponseEntity<?> deleteUsuario(@RequestParam("id") Integer id) {
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
