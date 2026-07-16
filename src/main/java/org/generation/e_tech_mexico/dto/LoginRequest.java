package org.generation.e_tech_mexico.dto;

public class LoginRequest {
    private String email;
    private String pass;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.pass = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}