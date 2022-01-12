package com.example.comerciodecelularvesp.BusinessTests;

import com.example.comerciodecelularvesp.business.PedidoBiz;
import com.example.comerciodecelularvesp.entities.Cliente;
import com.example.comerciodecelularvesp.entities.Pedido;
import com.example.comerciodecelularvesp.repositories.ClienteRepository;
import com.example.comerciodecelularvesp.repositories.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PedidoBizTests {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void DataNaoEPassadaTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            Pedido pedidoNovo = new Pedido();
            pedidoNovo.setModelo("Iphone 7");
            pedidoNovo.setData(Date.valueOf("2023-01-01"));
            pedidoNovo.setAtivo(true);
            pedidoNovo.setId(0);
            pedidoNovo.setValor(2000.00);
            pedidoNovo.setIdCliente(1);
            PedidoBiz pedidoBiz = new PedidoBiz(1,pedidoNovo, pedidoRepository,clienteRepository);
            if (pedidoBiz.dataNaoEPassada(pedidoNovo.getData())) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception ex) {
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void valorMinimoTest(){
        Boolean expected = true;

        Pedido pedido = new Pedido();

        pedido.setValor(5000.00);

        PedidoBiz pedidoBiz = new PedidoBiz(0, pedido, pedidoRepository, clienteRepository);

        Boolean result = pedidoBiz.valorDiferenteDeZero(pedido.getValor());

        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void clienteEAtivoTest(){
        Boolean expected = true;
        Pedido pedido = new Pedido();
        pedido.setIdCliente(2);

        PedidoBiz pedidoBiz = new PedidoBiz(0, pedido, pedidoRepository, clienteRepository);

        Boolean result = pedidoBiz.clienteEAtivo(pedido.getIdCliente());

        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void modeloComecaLetraMaiusculaTest(){
        Boolean expected = true;
        Pedido pedido = new Pedido();
        pedido.setModelo("Samsunggg 12");

        PedidoBiz pedidoBiz = new PedidoBiz(0, pedido, pedidoRepository, clienteRepository);

        Boolean result = pedidoBiz.modeloComecaLetraMaiuscula(pedido.getModelo());

        assertThat(result).isEqualTo(expected);
    }



}
