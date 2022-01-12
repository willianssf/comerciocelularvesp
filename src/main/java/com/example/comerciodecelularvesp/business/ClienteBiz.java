package com.example.comerciodecelularvesp.business;

import com.example.comerciodecelularvesp.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteBiz {

    private Cliente cliente;
    private List<String> erros;
    private Boolean incluindo;
    private Boolean alterando;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public ClienteBiz (int modo, Cliente cliente){
        this.incluindo = modo==0;
        this.alterando = modo!=0;
        this.cliente = cliente;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid(){
        Boolean resultado = true;

        resultado = nomeNaoEVazio(this.cliente.getNome()) && resultado;
        resultado = saldoMaiorIgual100(this.cliente.getSaldo()) && resultado;
        resultado = emailNaoEVazio(this.cliente.getEmail()) && resultado;

        return resultado;
    }

    public Boolean nomeNaoEVazio (String nome){
        Boolean resultado  = nome.matches("^[A-z]");
        if (!resultado){
            erros.add("O Nome não pode ser vazio!");
        }
        return resultado;
    }

    public Boolean saldoMaiorIgual100 (Double saldo){
        Boolean resultado  = saldo.doubleValue() >= 100;
        if (!resultado){
            erros.add("O Saldo mínimo deve ser 100!");
        }
        return resultado;
    }

    public Boolean emailNaoEVazio (String email){
        Boolean resultado  = email.matches("^[A-z0-9]");
        if (!resultado){
            erros.add("O email nao pode ser vazio!");
        }
        return resultado;
    }

}
