package org.generation.e_tech_mexico.dto;

public class PassDto {
    private String passActual;
    private String passNuevo;

    public PassDto() {
    }

    public PassDto(String passActual, String passNuevo) {
        this.passActual = passActual;
        this.passNuevo = passNuevo;
    }

    public String getPassActual() {
        return passActual;
    }

    public void setPassActual(String passActual) {
        this.passActual = passActual;
    }

    public String getPassNuevo() {
        return passNuevo;
    }

    public void setPassNuevo(String passNuevo) {
        this.passNuevo = passNuevo;
    }

    @Override
    public String toString() {
        return "PassDto{" + "passActual='" + passActual + '\'' + ", passNuevo='" + passNuevo + '\'' + '}';
    }
}