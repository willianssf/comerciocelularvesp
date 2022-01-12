package com.example.comerciodecelularvesp.BusinessTests;

import com.example.comerciodecelularvesp.business.CelularBiz;
import com.example.comerciodecelularvesp.entities.Celular;
import com.example.comerciodecelularvesp.repositories.CelularRepository;
import com.example.comerciodecelularvesp.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CelularBizTests {

    @Autowired
    private CelularRepository celularRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    private CelularBiz celularBiz;
    private Celular celular;

    private Boolean expected;

    public CelularBizTests(){
        expected = true;
    }

    @Test
    public void isValidTest(){

        celular = new Celular();

        celular.setId(0);
        celular.setNome("Maria");
        celular.setPreco(100.00);
        celular.setValor(100.00);
        celular.setIdCliente(2);

        celularBiz = new CelularBiz(0, celular, celularRepository, clienteRepository);

        Boolean result = celularBiz.isValid();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void nomePeloMenos3LetrasTest(){

        celular = new Celular();

        celular.setNome("Maria");

        celularBiz = new CelularBiz(0, celular, celularRepository, clienteRepository);

        Boolean result = celularBiz.nomePeloMenos3Letras(celular.getNome());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void precoPositivoTest(){
        celular = new Celular();

        celular.setPreco(100.00);

        celularBiz = new CelularBiz(0, celular, celularRepository, clienteRepository);

        Boolean result = celularBiz.precoPositivo(celular.getPreco());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void valorPositivoTest(){
        celular = new Celular();

        celular.setValor(100.00);

        celularBiz = new CelularBiz(0, celular, celularRepository, clienteRepository);

        Boolean result = celularBiz.valorPositivo(celular.getValor());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void verificadorDeClienteTest(){
        celular = new Celular();

        celular.setIdCliente(2);

        celularBiz = new CelularBiz(0, celular, celularRepository, clienteRepository);

        Boolean result = celularBiz.verificadorDeCliente(celular.getIdCliente());

        assertThat(result).isEqualTo(expected);
    }
}
