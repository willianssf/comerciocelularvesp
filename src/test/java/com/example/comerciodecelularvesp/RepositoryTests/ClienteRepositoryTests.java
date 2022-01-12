package com.example.comerciodecelularvesp.RepositoryTests;

import com.example.comerciodecelularvesp.entities.Cliente;

import com.example.comerciodecelularvesp.repositories.ClienteRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClienteRepositoryTests {
    @Autowired
    private ClienteRepository clienteRepository;

    private Boolean expected;

    public ClienteRepositoryTests(){
        expected = true;
    }

    @Test
    public void findByAtivoTest(){

        List<Cliente> lista = clienteRepository.findByAtivo(true);

        assertThat(!lista.isEmpty()).isEqualTo(expected);
    }
}
