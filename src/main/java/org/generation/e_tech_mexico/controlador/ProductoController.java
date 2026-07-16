package org.generation.e_tech_mexico.controlador;

import org.generation.e_tech_mexico.modelo.Producto;
import org.generation.e_tech_mexico.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/productos/")
@CrossOrigin("http://127.0.0.1:5502/")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.createProducto(producto);
    }

    @GetMapping
    public List<Producto> getProductos() {
        return productoService.getProductos();
    }

    @GetMapping("{productoId}")
    public Producto getProducto(@PathVariable("productoId") Long id) {
        return productoService.getProducto(id);
    }

    @PutMapping("{productoId}")
    public Producto updateProducto(
            @PathVariable("productoId") Long id,
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "descripcion", required = false) String descripcion,
            @RequestParam(value = "precio", required = false) Double precio,
            @RequestParam(value = "categoria", required = false) String categoria,
            @RequestParam(value = "urlImagen", required = false) String urlImagen,
            @RequestParam(value = "stock", required = false) Integer stock,
            @RequestParam(value = "fechaCreacion", required = false) LocalDateTime fechaCreacion
    ) {
        return productoService.updateProducto(id, nombre, descripcion, precio, categoria, urlImagen, stock, fechaCreacion);
    }

    @DeleteMapping("{productoId}")
    public Producto deleteProducto(@PathVariable("productoId") Long id) {
        return productoService.deleteProducto(id);
    }
}
