package org.generation.e_tech_mexico.controlador;

import jakarta.servlet.ServletException;
import org.generation.e_tech_mexico.dto.LoginRequest;
import org.generation.e_tech_mexico.dto.TokenAcceso;
import org.generation.e_tech_mexico.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/login/")
@CrossOrigin("http://127.0.0.1:5502/")
public class LoginController {

    private final UsuarioService usuarioService;

    @Autowired
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public TokenAcceso validarUsuario(@RequestBody LoginRequest request) throws ServletException {
        if (usuarioService.validarUsuario(request)) {
            TokenAcceso tokenAcceso = new TokenAcceso(usuarioService.generarToken(request.getEmail()));
            return tokenAcceso;
        }

        throw new ServletException("Login Error: el correo o la contraseña son inválidos");
    }
}