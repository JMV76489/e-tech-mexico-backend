package org.generation.e_tech_mexico.servicio;

import jakarta.servlet.ServletException;
import org.generation.e_tech_mexico.modelo.Usuario;
import org.generation.e_tech_mexico.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario createUsuario(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCorreoElectronico(usuario.getCorreoElectronico());

        if (usuarioOptional.isEmpty()) {
            return usuarioRepository.save(usuario);
        }

        return null;
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuario(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElseThrow(() -> new IllegalArgumentException("El usuario con el id [" + idUsuario + "] no existe"));
    }

    public Usuario updateUsuario(Long idUsuario, String nombreCompleto, String correoElectronico, String telefono, String password, String direccionEntrega) {


        return null;
    }

    public Usuario deleteUsuario(Long idUsuario) {
        if (usuarioRepository.existsById(idUsuario)) {
            Usuario deletedUsuario = usuarioRepository.findById(idUsuario).get();
            usuarioRepository.deleteById(idUsuario);
            return deletedUsuario;
        }
        return null;
    }
}
