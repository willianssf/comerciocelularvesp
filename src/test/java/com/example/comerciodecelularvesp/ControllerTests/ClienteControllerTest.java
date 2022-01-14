package com.example.comerciodecelularvesp.ControllerTests;

import com.example.comerciodecelularvesp.Mensagem;
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
            cliente.setSaldo(1100.0);
            cliente.setAtivo(true);
            Mensagem msg = clienteController.incluir(cliente);

            System.out.println(msg.getMensagem());
            if (!msg.getErro().isEmpty()){
                for(String s: msg.getErro()){
                    System.out.println(s);
                }
            }

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
            Cliente cliente = clienteController.buscar(this.idClienteTeste);
            cliente.setNome("Maristela Filho");
            cliente.setEmail("mnfialho@hotmail.com");
            cliente.setSaldo(100.0);
            cliente.setAtivo(true);
            Mensagem msg = clienteController.alterar(cliente);
            System.out.println(msg.getMensagem());
            Cliente clientealterado = clienteController.buscar(this.idClienteTeste);

            result = clienteEquals(cliente, clientealterado);

            System.out.println(result);

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


    public boolean clienteEquals( Cliente origem, Cliente destino){


        /*System.out.println(origem.getNome() + " =>" + destino.getNome() );
        System.out.println(origem.getAtivo() + " =>" + destino.getAtivo() );
        System.out.println(origem.getEmail() + " =>" + destino.getEmail() );
        System.out.println(origem.getSaldo() + " =>" + destino.getSaldo() );*/


        return origem.getNome().equals(destino.getNome()) &&
                origem.getAtivo().equals(destino.getAtivo()) &&
                origem.getEmail().equals(destino.getEmail()) &&
                origem.getSaldo().equals(destino.getSaldo());


    }





}
