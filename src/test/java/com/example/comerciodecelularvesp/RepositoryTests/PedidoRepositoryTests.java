package com.example.comerciodecelularvesp.RepositoryTests;

import com.example.comerciodecelularvesp.entities.Pedido;
import com.example.comerciodecelularvesp.repositories.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PedidoRepositoryTests {
    @Autowired
    private PedidoRepository pedidoRepository;

    private Boolean expected;

    public PedidoRepositoryTests(){
        expected = true;
    }

    @Test
    public void findByAtivoTest(){

        List<Pedido> lista = pedidoRepository.findByAtivo(true);

        assertThat(!lista.isEmpty()).isEqualTo(expected);
    }
}
