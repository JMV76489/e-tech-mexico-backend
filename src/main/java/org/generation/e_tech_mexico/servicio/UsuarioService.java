package org.generation.e_tech_mexico.servicio;

import org.generation.e_tech_mexico.dto.RegistroUsuarioDTO;
import org.generation.e_tech_mexico.modelo.Usuario;
import org.generation.e_tech_mexico.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario createUsuario(RegistroUsuarioDTO registroDTO) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombreCompleto(registroDTO.getNombre()); // Ajusta los setters según los nombres de atributos en tu clase Usuario.java
        nuevoUsuario.setCorreoElectronico(registroDTO.getEmail());
        nuevoUsuario.setTelefono(registroDTO.getTelefono());

        // 2. Encriptar la contraseña usando BCrypt antes de guardar
        String contrasenaEncriptada = passwordEncoder.encode(registroDTO.getContrasena());
        nuevoUsuario.setPassword(contrasenaEncriptada); // O setContrasenia() según tu entidad

        // 3. Persistir en la base de datos MySQL
        return usuarioRepository.save(nuevoUsuario);
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

    public Usuario obtenerUsuarioPorCorreo(String email) {
        return usuarioRepository.findByCorreoElectronico(email).orElse(null);
    }
}
