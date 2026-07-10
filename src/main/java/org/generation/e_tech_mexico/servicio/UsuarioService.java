package org.generation.e_tech_mexico.servicio;

import org.generation.e_tech_mexico.modelo.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private final ArrayList<Usuario> lista = new ArrayList<>();

    public Usuario createUsuario(Usuario usuario) {
        return lista.add(usuario) ? usuario : null;
    }

    public List<Usuario> getUsuarios() {
        return lista;
    }

    public Usuario getUsuario(Long idUsuario) {
        return lista
                .stream()
                .filter(usuario -> usuario.getIdUsuario().equals(idUsuario))
                .findFirst()
                .orElse(null);
    }

    public Usuario updateUsuario(Long idUsuario, String nombreCompleto, String correoElectronico, String telefono, String password, String direccionEntrega) {
        for (Usuario usuario : lista) {
            if (usuario.getIdUsuario().equals(idUsuario)) {
                if (nombreCompleto != null) usuario.setNombreCompleto(nombreCompleto);
                if (correoElectronico != null) usuario.setCorreoElectronico(correoElectronico);
                if (telefono != null) usuario.setTelefono(telefono);
                if (password != null) usuario.setPassword(password);
                if (direccionEntrega != null) usuario.setDireccionEntrega(direccionEntrega);
                return usuario;
            }
        }
        return null;
    }

    public Usuario deleteUsuario(Long idUsuario) {
        for (Usuario usuario : lista) {
            if (usuario.getIdUsuario().equals(idUsuario)) {
                lista.remove(usuario);
                return usuario;
            }
        }
        return null;
    }
}
