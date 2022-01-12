package com.example.comerciodecelularvesp.BusinessTest;

import com.example.comerciodecelularvesp.entities.Cliente;
import com.example.comerciodecelularvesp.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClienteRepositoryTeste {
    @Autowired
    private ClienteRepository clienteRepository;
    @Test
    public void findByAtivoTeste(){
        List<Cliente> lista = clienteRepository.findByAtivo(true);
        Boolean result = !lista.isEmpty();
        assertThat(true).isEqualTo(result);
    }
}
