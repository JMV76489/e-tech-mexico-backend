package org.generation.e_tech_mexico.modelo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    Long idProducto;

    @Column(name = "nombre", length = 50)
    String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    String descripcion;

    @Column(name = "precio")
    Double precio;

    @Column(name = "categoria", length = 50)
    String categoria;

    @Column(name = "url_imagen", columnDefinition = "TEXT")
    String urlImagen;

    @Column(name = "stock")
    Integer stock;

    @Column(name = "fecha_creacion")
    LocalDateTime fechaCreacion;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, Double precio, String categoria, String urlImagen, Integer stock, LocalDateTime fechaCreacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.urlImagen = urlImagen;
        this.stock = stock;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}