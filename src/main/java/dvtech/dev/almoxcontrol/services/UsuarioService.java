package dvtech.dev.almoxcontrol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dvtech.dev.almoxcontrol.models.Usuario;
import dvtech.dev.almoxcontrol.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario addUsuario(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository
                .findByLogin(usuario.getLogin());
        if (usuarioOptional.isPresent()) {
            throw new IllegalArgumentException("Usuario ja existe");
        } else {
            return usuarioRepository.save(usuario);
        }
    }

    public Usuario updateUsuario(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository
                .findByLogin(usuario.getLogin());
        if (usuarioOptional.isPresent()) {
            return usuarioRepository.save(usuario);
        } else {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
    }

    public void deleteUsuario(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalStateException(
                    "Não existe um usuário com o id " + id + ".");
        } else {
            usuarioRepository.deleteById(id);
        }
    }

    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario findUsuarioByLogin(String login) {
        Optional<Usuario> usuarioOptional = usuarioRepository
                .findByLogin(login);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
    }

    public Usuario findUsuarioById(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Usuário não encontrado"));
    };

}
