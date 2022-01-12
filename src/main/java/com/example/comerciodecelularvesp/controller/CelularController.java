package com.example.comerciodecelularvesp.controller;


import com.example.comerciodecelularvesp.Mensagem;
import com.example.comerciodecelularvesp.entities.Celular;
import com.example.comerciodecelularvesp.repositories.CelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("celular")
@CrossOrigin
public class CelularController {
    @Autowired
    private CelularRepository celularRepository;

    @GetMapping
    public List<Celular> listar(){
        List<Celular> lista = celularRepository.findByAtivo(true);
        return lista;
    }
    @GetMapping("/{id}")
    public Celular buscar(@PathVariable int id){
        Celular celular = celularRepository.findById(id).get();
        return celular;
    }
    @PostMapping
    public Mensagem incluir(@RequestBody Celular celular) {
        celular.setId(0);
        celularRepository.saveAndFlush(celular);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Inserido com sucesso!");
        return msg;
    }
    @PutMapping
    public Mensagem alterar(@RequestBody Celular celular){
        celularRepository.saveAndFlush(celular);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Alterado com sucesso!");
        return  msg;
    }
    @DeleteMapping
    public Mensagem deletar(@PathVariable int id){
        Celular celular = celularRepository.findById(id).get();
        celular.setAtivo(false);
        celularRepository.saveAndFlush(celular);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Celular deletado com sucesso");
        return msg;


    }
}
