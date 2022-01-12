package com.example.comerciodecelularvesp.RepositoryTests;

import com.example.comerciodecelularvesp.entities.Celular;
import com.example.comerciodecelularvesp.entities.Cliente;
import com.example.comerciodecelularvesp.repositories.CelularRepository;
import com.example.comerciodecelularvesp.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class CelularRepositoryTest {
    @Autowired
    private CelularRepository celularRepository;
    @Test
    public void findByAtivoTeste(){
        List<Celular> lista = celularRepository.findByAtivo(true);
        Boolean result = !lista.isEmpty();
        assertThat(true).isEqualTo(result);
    }
}
