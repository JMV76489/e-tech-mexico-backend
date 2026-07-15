package org.generation.e_tech_mexico.controlador;

import org.generation.e_tech_mexico.dto.LoginRequestDTO;
import org.generation.e_tech_mexico.dto.RegistroUsuarioDTO;
import org.generation.e_tech_mexico.modelo.Usuario;
import org.generation.e_tech_mexico.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RestController
@RequestMapping(path = "/api/usuarios/")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public Usuario createUser(@RequestBody RegistroUsuarioDTO registroDTO) {
        return usuarioService.createUsuario(registroDTO);
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("{usuarioId}")
    public Usuario getUsuario(@PathVariable("usuarioId") Long id) {
        return usuarioService.getUsuario(id);
    }

    @PutMapping("{usuarioId}")
    public Usuario updateUsuario(
            @PathVariable("usuarioId") Long id,
            @RequestParam(value = "nombreCompleto", required = false) String nombreCompleto,
            @RequestParam(value = "correoElectronico", required = false) String correoElectronico,
            @RequestParam(value = "telefono", required = false) String telefono,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "direccionEntrega", required = false) String direccionEntrega
    ) {
        return usuarioService.updateUsuario(id, nombreCompleto, correoElectronico, telefono, password, direccionEntrega);
    }

    @DeleteMapping("{usuarioId}")
    public Usuario deleteUsuario(@PathVariable("usuarioId") Long id) {
        return usuarioService.deleteUsuario(id);
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegistroUsuarioDTO registroDTO) {
        try {
            Usuario usuarioGuardado = usuarioService.createUsuario(registroDTO);
            return ResponseEntity.ok(usuarioGuardado); // Retorna el usuario creado (sin contraseña expuesta si lo prefieres) o un mensaje de éxito
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al registrar el usuario: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginDTO) {
        // 1. Buscar al usuario por correo
        Usuario usuario = usuarioService.obtenerUsuarioPorCorreo(loginDTO.getEmail()); // Deberás crear este método en tu servicio

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo electrónico no registrado.");
        }

        // 2. Validar que la contraseña ingresada coincida con el hash de BCrypt en la base de datos
        boolean coincide = passwordEncoder.matches(loginDTO.getContrasena(), usuario.getPassword());

        if (!coincide) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta.");
        }

        // 3. Responder con éxito si las credenciales son correctas
        return ResponseEntity.ok(usuario); // O retorna un JSON con los datos básicos que necesite el Front-End
    }


}