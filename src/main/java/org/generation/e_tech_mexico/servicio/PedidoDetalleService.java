package org.generation.e_tech_mexico.servicio;

import org.generation.e_tech_mexico.modelo.PedidoDetalle;
import org.generation.e_tech_mexico.repositorio.PedidoDetalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoDetalleService {

    private final PedidoDetalleRepository pedidoDetalleRepository;

    public PedidoDetalleService(PedidoDetalleRepository pedidoDetalleRepository) {
        this.pedidoDetalleRepository = pedidoDetalleRepository;
    }

    // Obtener todos
    public List<PedidoDetalle> obtenerTodos() {
        return pedidoDetalleRepository.findAll();
    }

    // Buscar por ID
    public PedidoDetalle buscarPorId(Long id) {
        return pedidoDetalleRepository.findById(id).orElse(null);
    }

    // Guardar
    public PedidoDetalle guardar(PedidoDetalle detalle) {
        return pedidoDetalleRepository.save(detalle);
    }

    // Actualizar
    public PedidoDetalle actualizar(Long id,
                                    Long idProducto,
                                    Long idPedido,
                                    Integer cantidad,
                                    Double subtotal) {

        PedidoDetalle detalle = pedidoDetalleRepository.findById(id).orElse(null);

        if (detalle == null) {
            return null;
        }

        if (idProducto != null) {
            detalle.setIdProducto(idProducto);
        }

        if (idPedido != null) {
            detalle.setIdPedido(idPedido);
        }

        if (cantidad != null) {
            detalle.setCantidad(cantidad);
        }

        if (subtotal != null) {
            detalle.setSubtotal(subtotal);
        }

        return pedidoDetalleRepository.save(detalle);
    }

    // Eliminar
    public void eliminar(Long id) {
        pedidoDetalleRepository.deleteById(id);
    }
}