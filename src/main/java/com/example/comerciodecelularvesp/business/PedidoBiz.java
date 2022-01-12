package com.example.comerciodecelularvesp.business;

import com.example.comerciodecelularvesp.entities.Pedido;
import com.example.comerciodecelularvesp.repositories.PedidoRepository;

import java.util.List;

public class PedidoBiz {
    private Pedido pedido;
    private PedidoRepository pedidoRepository;
    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public PedidoBiz (int modo, Pedido pedido, PedidoRepository pedidoRepository) {
        this.pedido = pedido;
        this.pedidoRepository = pedidoRepository;
    }

    public Boolean isValid() {
        Boolean resultado = true;
        return resultado;
    }

}
