package org.generation.e_tech_mexico.modelo;

//Todo realizar Jose
public class Pedido {

    // Mapeo de campos de la tabla SQL 'pedido'
    private Long idPedido;      // `id_pedido` INT
    private Long idUsuario;     // `id_usuario` INT
    private String fechaPedido; // `fecha_pedido` DATETIME (Simulado como String)
    private Double total;       // `total` DECIMAL(10,2)
    private String fechaEntrega;// `fecha_entrega` DATETIME (Simulado como String)

    // Constructor vacio
    public Pedido(){
    }// Constructor Pedido vacio

    // Constructor con todos los parámetros (Ideal para simular datos en el servicio)
    public Pedido(Long idPedido, Long idUsuario, String fechaPedido, Double total, String fechaEntrega){
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.fechaEntrega = fechaEntrega;
    }// Constructor Pedido

    // Getters & Setters

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

}// clase Pedido
