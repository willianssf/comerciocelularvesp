package com.example.comerciodecelularvesp.controller;

import com.example.comerciodecelularvesp.Mensagem;
import com.example.comerciodecelularvesp.business.ClienteBiz;
import com.example.comerciodecelularvesp.entities.Cliente;
import com.example.comerciodecelularvesp.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")

@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    private Cliente cliente;
    private Mensagem msg;

    @GetMapping
    public List<Cliente> listar(){
        List<Cliente> lista = clienteRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable int id){
        return cliente = clienteRepository.findById(id).get();
    }

    @PostMapping
    public Mensagem incluir(@RequestBody Cliente cliente){
        cliente.setId(0);
        ClienteBiz clienteBiz = new ClienteBiz(0, cliente);
        msg = new Mensagem();

        if (clienteBiz.isValid()) {
            clienteRepository.saveAndFlush(cliente);
            msg.setMensagem("Tudo certo, cliente cadastrado!");
        } else {
            msg.setErro( clienteBiz.getErros() );
            msg.setMensagem("Erro");
        }
        return msg;

    }
    @PutMapping
    public Mensagem alterar (@RequestBody Cliente cliente){
        ClienteBiz clienteBiz = new ClienteBiz(1, cliente);
        msg = new Mensagem();
        if (clienteBiz.isValid()) {
            clienteRepository.saveAndFlush(cliente);
            msg.setMensagem("Tudo certo, cadastro do cliente alterado!");
        } else {
            msg.setErro( clienteBiz.getErros() );
            msg.setMensagem("Erro");
        }
        return msg;
    }

    @DeleteMapping("/{id}")
    public Mensagem deletar(@PathVariable int id){

        cliente = clienteRepository.findById(id).get();

        cliente.setAtivo(false);
        clienteRepository.saveAndFlush(cliente);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Cliente deletado com sucesso!");
        return msg;

    }
}
