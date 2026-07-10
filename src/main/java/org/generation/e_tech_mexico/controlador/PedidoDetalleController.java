package org.generation.e_tech_mexico.controlador;

import org.generation.e_tech_mexico.modelo.PedidoDetalle;
import org.generation.e_tech_mexico.servicio.PedidoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pedido-detalles/")
public class PedidoDetalleController {

    private final PedidoDetalleService pedidoDetalleService;

    @Autowired
    public PedidoDetalleController(PedidoDetalleService pedidoDetalleService) {
        this.pedidoDetalleService = pedidoDetalleService;
    }

    @PostMapping
    public PedidoDetalle createPedidoDetalle(@RequestBody PedidoDetalle pedidoDetalle) {
        return pedidoDetalleService.createPedidoDetalle(pedidoDetalle);
    }

    @GetMapping
    public List<PedidoDetalle> getPedidoDetalles() {
        return pedidoDetalleService.getPedidoDetalles();
    }

    @GetMapping("{pedidoDetalleId}")
    public PedidoDetalle getPedidoDetalle(@PathVariable("pedidoDetalleId") Long id) {
        return pedidoDetalleService.getPedidoDetalle(id);
    }

    @PutMapping("{pedidoDetalleId}")
    public PedidoDetalle updatePedidoDetalle(
            @PathVariable("pedidoDetalleId") Long id,
            @RequestParam(value = "idProducto", required = false) Long idProducto,
            @RequestParam(value = "idPedido", required = false) Long idPedido,
            @RequestParam(value = "cantidad", required = false) Integer cantidad,
            @RequestParam(value = "subtotal", required = false) Double subtotal
    ) {
        return pedidoDetalleService.updatePedidoDetalle(id, idProducto, idPedido, cantidad, subtotal);
    }

    @DeleteMapping("{pedidoDetalleId}")
    public PedidoDetalle deletePedidoDetalle(@PathVariable("pedidoDetalleId") Long id) {
        return pedidoDetalleService.deletePedidoDetalle(id);
    }
}
