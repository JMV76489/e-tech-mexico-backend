package org.generation.e_tech_mexico.servicio;

import org.generation.e_tech_mexico.modelo.Pedido;
import org.generation.e_tech_mexico.modelo.PedidoDetalle;
import org.generation.e_tech_mexico.modelo.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoDetalleService {

    private final ArrayList<PedidoDetalle> lista = new ArrayList<>();

    public PedidoDetalle createPedidoDetalle(PedidoDetalle pedidoDetalle) {
        return lista.add(pedidoDetalle) ? pedidoDetalle : null;
    }

    public List<PedidoDetalle> getPedidoDetalles() {
        return lista;
    }

    public PedidoDetalle getPedidoDetalle(Long idPedidoDetalle) {
        return lista
                .stream()
                .filter(detalle -> detalle.getIdPedidoDetalle().equals(idPedidoDetalle))
                .findFirst()
                .orElse(null);
    }

    public PedidoDetalle updatePedidoDetalle(Long idPedidoDetalle, Producto producto, Pedido pedido, Integer cantidad, Double subtotal) {
        for (PedidoDetalle pedidoDetalle : lista) {
            if (pedidoDetalle.getIdPedidoDetalle().equals(idPedidoDetalle)) {
                if (producto != null) pedidoDetalle.setProducto(producto);
                if (pedido != null) pedidoDetalle.setPedido(pedido);
                if (cantidad != null) pedidoDetalle.setCantidad(cantidad);
                if (subtotal != null) pedidoDetalle.setSubtotal(subtotal);
                return pedidoDetalle;
            }
        }
        return null;
    }

    public PedidoDetalle deletePedidoDetalle(Long idPedidoDetalle) {
        for (PedidoDetalle pedidoDetalle : lista) {
            if (pedidoDetalle.getIdPedidoDetalle().equals(idPedidoDetalle)) {
                lista.remove(pedidoDetalle);
                return pedidoDetalle;
            }
        }
        return null;
    }
}
