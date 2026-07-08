package org.generation.e_tech_mexico.controlador;

//Todo Jose

import org.generation.e_tech_mexico.modelo.PedidoDetalle;
import org.generation.e_tech_mexico.servicio.PedidoDetalleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido-detalles")
@CrossOrigin(origins = "*") // Permite la conexión con tu Front-end local
public class PedidoDetalleController {
    private final PedidoDetalleService pedidoDetalleService;

    // Inyección de dependencias mediante el constructor
    public PedidoDetalleController(PedidoDetalleService pedidoDetalleService){
     this.pedidoDetalleService = pedidoDetalleService;
    }

    // 1. Endpoint GET: Obtener todos los detalles de los pedidos
    @GetMapping
    public List<PedidoDetalle> getAllDetalles(){
        return pedidoDetalleService.obtenerTodos();
    }

    // 2. Endpoint GET por ID: Encontrar un artículo específico por su ID
    @GetMapping("/{id}")
    public PedidoDetalle getDetalleById(@PathVariable Long id) {
        return pedidoDetalleService.buscarPorId(id);
    }

    // 3. Endpoint POST: Agregar un nuevo articulo al detalle del pedido
    @PostMapping
    public PedidoDetalle createDetalle(@RequestBody PedidoDetalle detalle){
        return pedidoDetalleService.guardar(detalle);
    }

    // 4. Endpoint PUT: Actualizar un detalle existente usando su ID
    @PutMapping("/{id}")
    public PedidoDetalle updateDetalle(
            @PathVariable("id") Long id,
            @RequestParam(value = "idProducto", required = false) Long idProducto,
            @RequestParam(value = "idPedido", required = false) Long idPedido,
            @RequestParam(value = "cantidad", required = false) Integer cantidad,
            @RequestParam(value = "subtotal", required = false) Double subtotal
    ) {
        return pedidoDetalleService.actualizar(id, idProducto, idPedido, cantidad, subtotal);
    }

    // 5. Endpoint DELETE: Eliminar un detalle usando su ID
    @DeleteMapping("/{id}")
    public void removeDetalle(@PathVariable Long id) {
        pedidoDetalleService.eliminar(id);
    }

}// Clase PedidoDetalleController
