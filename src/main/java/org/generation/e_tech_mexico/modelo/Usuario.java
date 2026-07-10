package org.generation.e_tech_mexico.modelo;

import jakarta.persistence.*;                                            // 🆕 NUEVO

@Entity                                                                   // 🆕 NUEVO
@Table(name = "usuario")                                                 // 🆕 NUEVO
public class Usuario {

    @Id                                                                  // 🆕 NUEVO
    @GeneratedValue(strategy = GenerationType.IDENTITY)                  // 🆕 NUEVO
    @Column(name = "id_usuario")                                         // 🆕 NUEVO
    private Long idUsuario;

    @Column(name = "nombre_completo", length = 150)                      // 🆕 NUEVO
    String nombreCompleto;

    @Column(name = "correo_electronico", nullable = false, length = 254) // 🆕 NUEVO
    String correoElectronico;

    @Column(name = "telefono", length = 20)                              // 🆕 NUEVO
    String telefono;

    @Column(name = "password", nullable = false, length = 255)           // 🆕 NUEVO
    String password;

    @Column(name = "direccion_entrega", length = 255)                    // 🆕 NUEVO
    String direccionEntrega;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombreCompleto, String correoElectronico, String telefono, String password, String direccionEntrega) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.password = password;
        this.direccionEntrega = direccionEntrega;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
}