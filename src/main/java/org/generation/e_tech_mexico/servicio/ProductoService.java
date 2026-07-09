package org.generation.e_tech_mexico.servicio;
//todo Adair

import org.generation.e_tech_mexico.modelo.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private final List<Producto> productos = new ArrayList<>();
    private Long siguienteId = 1L;

    public ProductoService() {
        productos.add(new Producto(siguienteId++, "Nintendo 64", 1899.00,
                "Consola retro Nintendo 64, incluye un control clasico.",
                "https://upload.wikimedia.org/wikipedia/commons/0/02/N64-Console-Set.png"));

        productos.add(new Producto(siguienteId++, "PlayStation 1", 1499.00,
                "Consola PS1 original, con un control.",
                "https://upload.wikimedia.org/wikipedia/commons/9/95/PSX-Console-wController.png"));

        productos.add(new Producto(siguienteId++, "Sega Genesis", 1299.00,
                "Consola Sega Genesis con dos controles.",
                "https://m.media-amazon.com/images/I/61we-OwU7mL._AC_UF1000,1000_QL80_.jpg"));
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    public Producto agregarProducto(Producto nuevoProducto) {
        nuevoProducto.setId(siguienteId++);
        productos.add(nuevoProducto);
        return nuevoProducto;
    }
}