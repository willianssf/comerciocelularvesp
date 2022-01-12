package com.example.comerciodecelularvesp.ControllerTests;
import com.example.comerciodecelularvesp.Mensagem;
import com.example.comerciodecelularvesp.controller.PedidoController;
import com.example.comerciodecelularvesp.entities.Pedido;
import com.example.comerciodecelularvesp.repositories.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.jar.Manifest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.stream;


@SpringBootTest
public class PedidoControllerTest {
    @Autowired
    private PedidoController pedidoController;
    @Autowired
    private PedidoRepository pedidoRepository;

    private int idPedidoTeste;

    public PedidoControllerTest(){
        this.idPedidoTeste = 2;
    }

    @Test
    public void BuscarTest(){
        Boolean expected = true;
        Boolean result = false;

        try {
            Pedido pedidoTest = pedidoController.buscar(this.idPedidoTeste);
            if(pedidoTest.getId() == this.idPedidoTeste){
                result = true;
            }else {
                result = false;
            }
        }catch (Exception ex){
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void ListarTest(){
        Boolean expected = true;
        Boolean result = false;

        if (pedidoController.listar().stream().count() > 0){
            result = true;
        }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void IncluirTest(){
        Boolean expected = true;
        Boolean result = false;
        long registrosAntes;
        long registrosDepois;

        try {
            registrosAntes = pedidoController.listar().stream().count();
            Pedido pedido = new Pedido();
            pedido.setAtivo(true);
            pedido.setModelo("GalaxyS20Fe");
            pedido.setId(0);
            pedido.setValor(1900.50);
            pedido.setData(Date.valueOf("2022-03-12"));
            pedido.setIdCliente(1);
            Mensagem msg = pedidoController.incluir(pedido);

            registrosDepois = pedidoController.listar().stream().count();
            if (registrosDepois == registrosAntes +1){
                result = true;
            }else {
                result = false;
            }
        }catch (Exception ex){
            result = false;
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void AlterarTest(){
        Boolean expected = true;
        Boolean result = false;

        Pedido pedido = pedidoController.buscar(this.idPedidoTeste);
        Pedido pedidoSemAlteracao = pedidoController.buscar(this.idPedidoTeste);

        pedido.setAtivo(true);
        pedido.setValor(1500.00);
        pedido.setIdCliente(8888);
        pedido.setModelo("GalaxyS21Fe");
        pedido.setData(Date.valueOf("2022-02-15"));

        pedidoController.alterar(pedido);
        if (!pedido.equals(pedidoSemAlteracao)){
            result = true;
        }

        assertThat(result).isEqualTo(expected);
    }




}
