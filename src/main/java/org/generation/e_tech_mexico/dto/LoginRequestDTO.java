package org.generation.e_tech_mexico.dto;

public class LoginRequestDTO {
    private String email;
    private String contrasena;

    // Constructor vacío (requerido por Jackson para deserializar el JSON)
    public LoginRequestDTO() {
    }

    // Constructor con parámetros
    public LoginRequestDTO(String email, String contrasenia) {
        this.email = email;
        this.contrasena = contrasenia;
    }

    // Getters y Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}// class LoginRequestDTO
