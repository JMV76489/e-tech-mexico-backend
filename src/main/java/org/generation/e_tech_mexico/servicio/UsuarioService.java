package org.generation.e_tech_mexico.servicio;

import org.generation.e_tech_mexico.modelo.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    // Lista en memoria para simular la base de datos
    private List<Usuario> usuarios = new ArrayList<>();

    // Contador para generar IDs únicos
    private Long contadorId = 1L;

    // Método renombrado a guardarUsuario para que coincida con el controlador de Adair
    public Usuario guardarUsuario(Usuario usuario) {
        usuario.setId(contadorId++);
        usuarios.add(usuario);
        return usuario;
    }

    // Método para listar usuarios
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
}