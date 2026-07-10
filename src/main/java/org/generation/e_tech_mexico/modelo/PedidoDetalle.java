package org.generation.e_tech_mexico.modelo;

public class PedidoDetalle {

    private Long idPedidoDetalle;
    private Long idProducto;
    private Long idPedido;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    public PedidoDetalle() {
    }

    public PedidoDetalle(Long idPedidoDetalle, Long idProducto, Long idPedido, int cantidad, double precioUnitario, double subtotal) {
        this.idPedidoDetalle = idPedidoDetalle;
        this.idProducto = idProducto;
        this.idPedido = idPedido;
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

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
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