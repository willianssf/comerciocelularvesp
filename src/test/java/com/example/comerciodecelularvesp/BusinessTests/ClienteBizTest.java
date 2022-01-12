package com.example.comerciodecelularvesp.BusinessTests;

import com.example.comerciodecelularvesp.business.ClienteBiz;
import com.example.comerciodecelularvesp.entities.Cliente;
import com.example.comerciodecelularvesp.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClienteBizTest {


    private Boolean expected;

    public ClienteBizTest(){
        expected = true;
    }

    @Test
    public void isValidTest(){
      Cliente cliente = new Cliente();

        cliente.setId(0);
        cliente.setNome("");
        cliente.setSaldo(120.0);
        cliente.setEmail("emailveterinario333333@gmail.com");

        ClienteBiz clienteBiz = new ClienteBiz(0, cliente);
        Boolean resultado = clienteBiz.isValid();

        assertThat(resultado).isEqualTo(expected);
    }

    @Test
    public void nomeNaoEVazioTest(){
        Cliente cliente = new Cliente();
        cliente.setNome("sadad");

        ClienteBiz clienteBiz = new ClienteBiz(0, cliente);

        Boolean resultado = clienteBiz.nomeNaoEVazio(cliente.getNome());
        assertThat(resultado).isEqualTo(expected);
    }

    @Test
    public void saldoMaiorIgual100Test(){
        Cliente cliente = new Cliente();
        cliente.setSaldo(101.0);

        ClienteBiz clienteBiz = new ClienteBiz(0, cliente);

        Boolean resultado = clienteBiz.saldoMaiorIgual100(cliente.getSaldo());
        assertThat(resultado).isEqualTo(expected);
    }

    @Test
    public void emailNaoEVazioTest(){
        Cliente cliente = new Cliente();
        cliente.setEmail("");

        ClienteBiz clienteBiz = new ClienteBiz(0, cliente);

        Boolean resultado = clienteBiz.emailNaoEVazio(cliente.getEmail());
        assertThat(resultado).isEqualTo(expected);
    }
}
