package org.generation.e_tech_mexico.servicio;

import org.generation.e_tech_mexico.modelo.Pedido;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final ArrayList<Pedido> lista = new ArrayList<>();

    public List<Pedido> getPedidos() {
        return this.lista;
    }

    public Pedido getPedido(Long idPedido) {
        return lista
                .stream()
                .filter(curPedido -> curPedido.getIdPedido().equals(idPedido))
                .findFirst().orElse(null);
    }

    public Pedido createPedido(Pedido pedido) {
        return lista.add(pedido) ? pedido : null;
    }

    public Pedido removePedido(Long idPedido) {
        for (Pedido curPedido : lista) {
            if (curPedido.getIdPedido().equals(idPedido)) {
                lista.remove(curPedido);
                return curPedido;
            }
        }
        return null;
    }

    public Pedido updatePedido(Long id, Long idUsuario, LocalDateTime fechaPedido, Double total, LocalDateTime fechaEntrega) {
        for (Pedido curPedido : lista) {
            if (curPedido.getIdPedido().equals(id)) {
                if (idUsuario != null) curPedido.setIdUsuario(idUsuario);
                if (fechaPedido != null) curPedido.setFechaPedido(fechaPedido);
                if (total != null) curPedido.setTotal(total);
                if (fechaEntrega != null) curPedido.setFechaEntrega(fechaEntrega);
                return curPedido;
            }
        }
        return null;
    }
}
