package org.generation.e_tech_mexico.servicio;

import org.generation.e_tech_mexico.modelo.Pedido;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final ArrayList<Pedido> lista = new ArrayList<>();


    public Pedido createPedido(Pedido pedido) {
        return lista.add(pedido) ? pedido : null;
    }

    public List<Pedido> getPedidos() {
        return lista;
    }

    public Pedido getPedido(Long idPedido) {
        return lista
                .stream()
                .filter(pedido -> pedido.getIdPedido().equals(idPedido))
                .findFirst().orElse(null);
    }

    public Pedido updatePedido(Long id, Long idUsuario, LocalDateTime fechaPedido, Double total, LocalDateTime fechaEntrega) {
        for (Pedido pedido : lista) {
            if (pedido.getIdPedido().equals(id)) {
                if (idUsuario != null) pedido.setIdUsuario(idUsuario);
                if (fechaPedido != null) pedido.setFechaPedido(fechaPedido);
                if (total != null) pedido.setTotal(total);
                if (fechaEntrega != null) pedido.setFechaEntrega(fechaEntrega);
                return pedido;
            }
        }
        return null;
    }

    public Pedido deletePedido(Long idPedido) {
        for (Pedido pedido : lista) {
            if (pedido.getIdPedido().equals(idPedido)) {
                lista.remove(pedido);
                return pedido;
            }
        }
        return null;
    }
}
