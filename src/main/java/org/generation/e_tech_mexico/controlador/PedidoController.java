package org.generation.e_tech_mexico.controlador;

import org.generation.e_tech_mexico.modelo.Pedido;
import org.generation.e_tech_mexico.modelo.Usuario;
import org.generation.e_tech_mexico.servicio.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/pedidos/")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoService.createPedido(pedido);
    }

    @GetMapping
    public List<Pedido> getPedidos() {
        return pedidoService.getPedidos();
    }

    @GetMapping("{pedidoId}")
    public Pedido getPedido(@PathVariable("pedidoId") Long id) {
        return pedidoService.getPedido(id);
    }

    @PutMapping("{pedidoId}")
    public Pedido updatePedido(
            @PathVariable("pedidoId") Long id,
            @RequestParam(value = "idUsuario", required = false) Usuario usuario,
            @RequestParam(value = "fechaPedido", required = false) LocalDateTime fechaPedido,
            @RequestParam(value = "total", required = false) Double total,
            @RequestParam(value = "fechaEntrega", required = false) LocalDateTime fechaEntrega
    ) {
        return pedidoService.updatePedido(id, usuario, fechaPedido, total, fechaEntrega);

    }

    @DeleteMapping("{pedidoId}")
    public Pedido deletePedido(@PathVariable("pedidoId") Long id) {
        return pedidoService.deletePedido(id);
    }

}
