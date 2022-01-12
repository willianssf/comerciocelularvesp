package com.example.comerciodecelularvesp.business;

import com.example.comerciodecelularvesp.entities.Pedido;
import com.example.comerciodecelularvesp.repositories.PedidoRepository;

public class PedidoBiz {
    private Pedido pedido;
    private PedidoRepository pedidoRepository;

    public PedidoBiz (int modo, Pedido pedido, PedidoRepository pedidoRepository) {
        this.pedido = pedido;
        this.pedidoRepository = pedidoRepository;
    }
}
