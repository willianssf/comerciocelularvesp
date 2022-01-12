package com.example.comerciodecelularvesp.controller;

import com.example.comerciodecelularvesp.Mensagem;
import com.example.comerciodecelularvesp.business.PedidoBiz;
import com.example.comerciodecelularvesp.entities.Pedido;
import com.example.comerciodecelularvesp.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("pedido")
@CrossOrigin
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> listar() {
        List<Pedido> lista = pedidoRepository.findByAtvio(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable int id) {
        Pedido pedido = pedidoRepository.findById(id).get();
        return pedido;
    }

    @PostMapping
    public Mensagem incluir(@RequestBody Pedido pedido) {
        pedido.setId(0);
        PedidoBiz pedidoBiz = new PedidoBiz(pedido.getId(), pedido, pedidoRepository);
        Mensagem msg = new Mensagem();

        if (pedidoBiz.isValid()) {
            pedidoRepository.saveAndFlush(pedido);
            msg.setMensagem("Pedido cadastrado com sucesso.");
        } else {
            msg.setErro(pedidoBiz.getErros());
            msg.setMensagem("Erro");
        }
        return msg;
    }

    @PutMapping
    public Mensagem alterar(@RequestBody Pedido pedido) {
        PedidoBiz pedidoBiz = new PedidoBiz(pedido.getId(), pedido, pedidoRepository);
        Mensagem msg = new Mensagem();

        if (pedidoBiz.isValid()) {
            pedidoRepository.saveAndFlush(pedido);
            msg.setMensagem("Pedido alterado com sucesso.");
        } else {
            msg.setErro(pedidoBiz.getErros());
            msg.setMensagem("Erro");
        }
        return msg;
    }
}
