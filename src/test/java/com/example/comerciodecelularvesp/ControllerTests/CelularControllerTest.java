package com.example.comerciodecelularvesp.ControllerTests;

import com.example.comerciodecelularvesp.controller.CelularController;
import com.example.comerciodecelularvesp.entities.Celular;
import com.example.comerciodecelularvesp.repositories.CelularRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CelularControllerTest {
    @Autowired
    private CelularController celularController;
    @Autowired
    private CelularRepository celularRepository;
    private int idCelularTeste;

    public CelularControllerTest(){this.idCelularTeste = 2;}

    @Test
    public void BuscarTest(){
        Boolean expected = true;
        Boolean result = false;

        try {
            Celular celularTest = celularController.buscar(this.idCelularTeste);
            if (celularTest.getId() == this.idCelularTeste) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception ex){
                result = false;
            }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void ListarTest() {
        Boolean expected = true;
        Boolean result = false;

        if (celularController.listar().stream().count() > 0) {
            result = true;
        }
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void IncluirTest() {
        Boolean expected = true;
        Boolean result = false;
        long registros_antes;
        long registros_depois;

        try {
            registros_antes = celularController.listar().stream().count();
            Celular celular = new Celular();
            celular.setNome("Apple");
            celular.setPreco(3000.00);
            celular.setModelo("Iphone 12");
            celular.setValor(4000.00);
            celular.setAtivo(true);
            celular.setIdCliente(1);
            celularController.incluir(celular);

            registros_depois = celularController.listar().stream().count();
            if (registros_depois > registros_antes) {
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
    public void AlterarTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            Celular celularnovo = celularController.buscar(this.idCelularTeste);

            Celular celularantigo = celularController.buscar(this.idCelularTeste);
            celularnovo.setNome("Apple");
            celularnovo.setPreco(2500.00);
            celularnovo.setModelo("Iphone X");
            celularController.alterar(celularnovo);
            celularnovo = celularController.buscar(this.idCelularTeste);
            if (celularnovo == celularantigo) {
                result = false;
            } else {
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
            Celular celulardeletar = celularController.buscar(this.idCelularTeste);
            celulardeletar.setAtivo(false);
            celularController.deletar(celulardeletar.getId());
            List<Celular> lista = celularRepository.findByAtivo(true);
            if (lista.contains(celulardeletar)) {
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
