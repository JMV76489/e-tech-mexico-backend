package com.etech.service;

import com.etech.model.PedidoDetalle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoDetalleService {

    public List<PedidoDetalle> obtenerTodos() {
        return new ArrayList<>();
    }

    public PedidoDetalle obtenerPorId(Long id) {
        return null;
    }

    public PedidoDetalle guardar(PedidoDetalle pedidoDetalle) {
        return pedidoDetalle;
    }

    public void eliminar(Long id) {

    }
}