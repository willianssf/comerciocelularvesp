package com.example.comerciodecelularvesp.controller;

<<<<<<< HEAD
=======
import com.example.comerciodecelularvesp.Mensagem;
import com.example.comerciodecelularvesp.business.PedidoBiz;
>>>>>>> e03ed9406eb126ecc56e8e7a922ded748645af9e
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

<<<<<<< HEAD
=======
    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable int id) {
        Pedido pedido = pedidoRepository.findById(id).get();
        return pedido;
    }

    @PostMapping
    public Mensagem incluir(@RequestBody Pedido pedido) {
        PedidoBiz pedidoBiz = new PedidoBiz(pedido.getId(), pedido, pedidoRepository);
        Mensagem msg = new Mensagem();
        return msg;
    }
>>>>>>> e03ed9406eb126ecc56e8e7a922ded748645af9e
}
