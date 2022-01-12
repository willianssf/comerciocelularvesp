package com.example.comerciodecelularvesp.controller;

import com.example.comerciodecelularvesp.entities.Pedido;
import com.example.comerciodecelularvesp.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
