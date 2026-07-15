package org.generation.e_tech_mexico.servicio;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.ServletException;
import org.generation.e_tech_mexico.configuracion.JwtFilter;
import org.generation.e_tech_mexico.dto.LoginRequest;
import org.generation.e_tech_mexico.dto.PassDto;
import org.generation.e_tech_mexico.modelo.Usuario;
import org.generation.e_tech_mexico.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario createUsuario(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCorreoElectronico(usuario.getCorreoElectronico());

        if (usuarioOptional.isEmpty()) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
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

    public Usuario updateUsuarioPassword(Long id, PassDto passDto) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = usuarioRepository.findById(id).get();

            if (passwordEncoder.matches(passDto.getPassActual(), usuario.getPassword())) {
                System.out.println("Actualizando usuario");
                usuario.setPassword(passwordEncoder.encode(passDto.getPassNuevo()));
                return usuarioRepository.save(usuario);
            }
        }
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

    public boolean validarUsuario(LoginRequest loginRequest) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByCorreoElectronico(loginRequest.getEmail());

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();

            if (passwordEncoder.matches(loginRequest.getPassword(), usuario.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public String generarToken(String email) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 24);

        return Jwts.builder()
                .subject(email)
                .claim("role", "user")
                .issuedAt(new Date())
                .expiration(calendar.getTime())
                .signWith(JwtFilter.getSignInKey())
                .compact();
    }
}
