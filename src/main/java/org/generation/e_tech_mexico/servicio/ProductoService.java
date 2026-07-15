package org.generation.e_tech_mexico.servicio;

import org.generation.e_tech_mexico.modelo.Producto;
import org.generation.e_tech_mexico.repositorio.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    public Producto getProducto(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El producto con el id [" + id + "] no existe"));
    }

    public Producto updateProducto(Long id, String nombre, String descripcion, Double precio, String categoria, String urlImagen, Integer stock, LocalDateTime fechaCreacion) {
        if (productoRepository.existsById(id)) {
            Producto producto = productoRepository.findById(id).get();

            if (nombre != null) producto.setNombre(nombre);
            if (descripcion != null) producto.setDescripcion(descripcion);
            if (precio != null) producto.setPrecio(precio);
            if (categoria != null) producto.setCategoria(categoria);
            if (urlImagen != null) producto.setUrlImagen(urlImagen);
            if (stock != null) producto.setStock(stock);
            if (fechaCreacion != null) producto.setFechaCreacion(fechaCreacion);

            return productoRepository.save(producto);
        }
        return null;
    }

    public Producto deleteProducto(Long id) {
        if (productoRepository.existsById(id)) {
            Producto deletedProducto = productoRepository.findById(id).get();
            productoRepository.deleteById(id);
            return deletedProducto;
        }

        return null;
    }
}