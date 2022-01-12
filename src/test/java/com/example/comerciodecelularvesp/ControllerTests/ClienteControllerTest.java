package com.example.comerciodecelularvesp.ControllerTests;

import com.example.comerciodecelularvesp.controller.ClienteController;
import com.example.comerciodecelularvesp.entities.Cliente;
import com.example.comerciodecelularvesp.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClienteControllerTest {
    @Autowired
    private ClienteController clienteController;
    @Autowired
    private ClienteRepository clienteRepository;
    private int idClienteTeste;
    public ClienteControllerTest() {this.idClienteTeste = 1;}
    @Test
    public void BuscarTest() {
        Boolean expected = true;
        Boolean result = false;

        try {
            Cliente clienteTeste = clienteController.buscar(this.idClienteTeste);
            if (clienteTeste.getId() == this.idClienteTeste) {
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
    public void ListarTest() {
        Boolean expected = true;
        Boolean result = false;

        if (clienteController.listar().stream().count() > 0) {
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
            registros_antes = clienteController.listar().stream().count();
            Cliente cliente = new Cliente();
            cliente.setNome("Cleude");
            cliente.setEmail("cleudinha@gmail.com");
            cliente.setSaldo(1000.0);
            cliente.setAtivo(true);
            clienteController.incluir(cliente);

            registros_depois = clienteController.listar().stream().count();
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
            Cliente clientenovo = clienteController.buscar(this.idClienteTeste);
            Cliente clienteantigo = clienteController.buscar(this.idClienteTeste);
            clientenovo.setNome("Maristela Filho");
            clientenovo.setEmail("mnfialho@hotmail.com");
            clientenovo.setSaldo(684.0);
            clienteController.alterar(clientenovo);
            clientenovo = clienteController.buscar(this.idClienteTeste);
            if (clientenovo == clienteantigo) {
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
            Cliente clientedelete = clienteController.buscar(this.idClienteTeste);
            clientedelete.setAtivo(false);
            clienteController.deletar(clientedelete.getId());
            List<Cliente> lista = clienteRepository.findByAtivo(true);
            if (lista.contains(clientedelete)) {
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
