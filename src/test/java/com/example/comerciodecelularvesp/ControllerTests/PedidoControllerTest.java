package com.example.comerciodecelularvesp.ControllerTests;
import com.example.comerciodecelularvesp.Mensagem;
import com.example.comerciodecelularvesp.controller.PedidoController;
import com.example.comerciodecelularvesp.entities.Cliente;
import com.example.comerciodecelularvesp.entities.Pedido;
import com.example.comerciodecelularvesp.repositories.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
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
            pedido.setModelo("GalaxyS22");
            pedido.setId(0);
            pedido.setValor(3000.50);
            pedido.setData(Date.valueOf("2022-03-17"));
            pedido.setIdCliente(1);
            Mensagem msg = pedidoController.incluir(pedido);

            registrosDepois = pedidoController.listar().stream().count();
            if (registrosDepois > registrosAntes){
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
    public void AlterarTest() {
        Boolean expected = true;
        Boolean result = false;
        try {
            Pedido pedido1 = new Pedido();
            pedido1 = pedidoController.buscar(1);

            pedido1.setModelo("Xiaomi887");
            pedido1.setValor(100.0);
            pedido1.setData(Date.valueOf("2022-11-12"));
            pedido1.setIdCliente(10);

            Pedido pedidoSemAlteracao = pedidoController.buscar(2);

            Mensagem msg = pedidoController.alterar(pedido1);

            if (!msg.getErro().isEmpty()) {
                result = false;
            }else{
                result = true;
            }

        } catch (Exception ex) {
                result = false;
        }
        assertThat(result).isEqualTo(expected);
        }


        @Test
        public void DeletarTest() {
             Boolean expected = true;
            Boolean result = false;

            try {
                Pedido pedidoDelete = pedidoController.buscar(this.idPedidoTeste);
                pedidoDelete.setAtivo(false);
                pedidoController.deletar(pedidoDelete.getId());
                List<Pedido> lista = pedidoRepository.findByAtivo(true);
                if (lista.contains(pedidoDelete)) {
                    result = false;
                } else {
                    result = true;
                }
            } catch (Exception ex) {
                result = false;
            }
            assertThat(result).isEqualTo(expected);
        }
    }


