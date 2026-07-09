package org.generation.e_tech_mexico.servicio;

import org.generation.e_tech_mexico.modelo.Producto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private final ArrayList<Producto> lista = new ArrayList<>();

    public Producto createProducto(Producto producto) {
        return lista.add(producto) ? producto : null;
    }

    public List<Producto> getProductos() {
        return lista;
    }

    public Producto getProducto(Long idProducto) {
        return lista
                .stream()
                .filter(producto -> producto.getIdProducto().equals(idProducto))
                .findFirst()
                .orElse(null);
    }

    public Producto updateProducto(Long id, String nombre, String descripcion, Double precio, String categoria, String urlImagen, Integer stock, LocalDateTime fechaCreacion) {
        for (Producto producto : lista) {
            if (producto.getIdProducto().equals(id)) {
                if (nombre != null) producto.setNombre(nombre);
                if (descripcion != null) producto.setDescripcion(descripcion);
                if (precio != null) producto.setPrecio(precio);
                if (categoria != null) producto.setCategoria(categoria);
                if (urlImagen != null) producto.setUrlImagen(urlImagen);
                if (stock != null) producto.setStock(stock);
                if (fechaCreacion != null) producto.setFechaCreacion(fechaCreacion);
                return producto;
            }
        }
        return null;
    }

    public Producto deleteProducto(Long idProducto) {
        for (Producto producto : lista) {
            if (producto.getIdProducto().equals(idProducto)) {
                lista.remove(producto);
                return producto;
            }
        }
        return null;
    }
}