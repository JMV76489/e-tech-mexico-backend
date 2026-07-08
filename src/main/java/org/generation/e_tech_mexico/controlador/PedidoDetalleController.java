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

    // 2. Endpoint POST: Agregar un nuevo articulo al detalle del pedido
    @PostMapping
    public PedidoDetalle createDetalle(@RequestBody PedidoDetalle detalle){
        return pedidoDetalleService.guardar(detalle);
    }

}// Clase PedidoDetalleController
