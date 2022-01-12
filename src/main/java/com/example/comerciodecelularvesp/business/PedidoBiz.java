package com.example.comerciodecelularvesp.business;

import com.example.comerciodecelularvesp.entities.Pedido;
import com.example.comerciodecelularvesp.repositories.ClienteRepository;
import com.example.comerciodecelularvesp.repositories.PedidoRepository;

import java.util.List;

public class PedidoBiz {
    private Pedido pedido;
    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;
    private Boolean incluindo;
    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public PedidoBiz (int modo, Pedido pedido, PedidoRepository pedidoRepository) {
        this.incluindo = modo==0;
        this.pedido = pedido;
        this.pedidoRepository = pedidoRepository;
    }

    public Boolean isValid() {
        Boolean resultado = true;
        return resultado;
    }
    //Quando um pedido é criado a data não pode ser no passado
    //Valor não pode ser 0
    //Cliente precisa ser ativo

}
