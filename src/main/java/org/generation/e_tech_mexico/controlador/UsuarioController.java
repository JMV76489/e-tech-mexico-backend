package org.generation.e_tech_mexico.controlador;

import org.generation.e_tech_mexico.modelo.Usuario;
import org.generation.e_tech_mexico.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/usuarios/")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.createUsuario(usuario);
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
}