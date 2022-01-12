package com.example.comerciodecelularvesp.business;

import com.example.comerciodecelularvesp.entities.Pedido;
import com.example.comerciodecelularvesp.repositories.ClienteRepository;
import com.example.comerciodecelularvesp.repositories.PedidoRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
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

    public PedidoBiz (int modo, Pedido pedido, PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.incluindo = modo==0;
        this.pedido = pedido;
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid() {
        Boolean resultado = true;
        if (this.incluindo) {
            resultado = dataNaoEPassada(this.pedido.getData()) && resultado;
        }
        resultado = valorDiferenteDeZero(this.pedido.getValor()) && resultado;
        resultado = clienteEAtivo(this.pedido.getIdCliente()) && resultado;
        return resultado;
    }
    //Quando um pedido é criado a data não pode ser no passado
    public Boolean dataNaoEPassada (Date data) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date hoje = Date.valueOf(LocalDate.now());
        if (data.before(hoje)) {
            erros.add("A data não pode ser passada, escolha a data atual ou posterior.");
            return false;
        } else {
            return true;
        }
    }
    //Valor não pode ser 0
    public Boolean valorDiferenteDeZero (Double valor) {
        Boolean resultado = valor.doubleValue() != 0;
        if (!resultado) {
            erros.add("O preço não pode ser abaixo ou igual a 0.");
        }
        return resultado;
    }
    //Cliente precisa ser ativo
    public Boolean clienteEAtivo (Integer id) {
        if (clienteRepository.findById(id).isPresent()) {
            Boolean ativo = clienteRepository.findById(id).get().getAtivo();
            if (!ativo) {
                erros.add("Cliente não é ativo.");
            }
            return ativo;
        } else {
            erros.add("Cliente não esta cadastrado no sistema.");
            return false;
        }
    }
    //Modelo precisa começar com letra maiúscula
    public Boolean modeloComecaLetraMaiuscula (String modelo) {
        Boolean resultado = modelo.matches("^[A-Z]{1}");
        if (!resultado) {
            erros.add("O modelo precisa começar com a letra maiúscula.");
        }
        return resultado;
    }
}
