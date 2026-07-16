package org.generation.e_tech_mexico.controlador;

import org.generation.e_tech_mexico.dto.PassDto;
import org.generation.e_tech_mexico.modelo.Usuario;
import org.generation.e_tech_mexico.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/usuarios/")
@CrossOrigin("http://127.0.0.1:5502/")
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
    public Usuario updateUsuario(@PathVariable("id") Long id, @RequestBody PassDto passDto) {
        return usuarioService.updateUsuarioPassword(id, passDto);
    }

    @DeleteMapping("{usuarioId}")
    public Usuario deleteUsuario(@PathVariable("usuarioId") Long id) {
        return usuarioService.deleteUsuario(id);
    }
}