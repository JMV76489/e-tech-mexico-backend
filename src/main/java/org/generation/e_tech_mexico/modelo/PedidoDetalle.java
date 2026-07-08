package com.etech.model;

public class PedidoDetalle {

    private Long idPedidoDetalle;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    public PedidoDetalle() {
    }

    public PedidoDetalle(Long idPedidoDetalle, int cantidad, double precioUnitario, double subtotal) {
        this.idPedidoDetalle = idPedidoDetalle;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public Long getIdPedidoDetalle() {
        return idPedidoDetalle;
    }

    public void setIdPedidoDetalle(Long idPedidoDetalle) {
        this.idPedidoDetalle = idPedidoDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}