package org.generation.e_tech_mexico.servicio;

import org.generation.e_tech_mexico.modelo.PedidoDetalle;
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

    public PedidoDetalle updatePedidoDetalle(Long idPedidoDetalle, Long idProducto, Long idPedido, Integer cantidad, Double subtotal) {
        for (PedidoDetalle pedidoDetalle : lista) {
            if (pedidoDetalle.getIdPedidoDetalle().equals(idPedidoDetalle)) {
                if (idProducto != null) pedidoDetalle.setIdProducto(idProducto);
                if (idPedido != null) pedidoDetalle.setIdPedido(idPedido);
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
