package com.example.comerciodecelularvesp.ControllerTests;
import com.example.comerciodecelularvesp.controller.PedidoController;
import com.example.comerciodecelularvesp.entities.Pedido;
import com.example.comerciodecelularvesp.repositories.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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


}
