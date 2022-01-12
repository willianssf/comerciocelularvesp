package com.example.comerciodecelularvesp.business;

import com.example.comerciodecelularvesp.entities.Celular;
import com.example.comerciodecelularvesp.entities.Cliente;
import com.example.comerciodecelularvesp.repositories.CelularRepository;
import com.example.comerciodecelularvesp.repositories.ClienteRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

//Nome deve possuir no mínimo 3 letras
//preço positivo
//valor positivo
//só pode ter regstro para clientes ativos
public class CelularBiz {
    private Celular celular;
    private CelularRepository celularRepository;
    private ClienteRepository clienteRepository;
    private Boolean incluindo;
    private Boolean alterando;

    public List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public CelularBiz(int modo, Celular celular, CelularRepository celularRepository, ClienteRepository clienteRepository){
        this.incluindo = modo ==0;
        this.alterando = modo !=0;

        this.celular = celular;
        this.celularRepository = celularRepository;
        this.clienteRepository = clienteRepository;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid(){
        Boolean resultado = true;
        resultado = nomePeloMenos3Letras(this.celular.getNome()) && resultado;
        resultado = precoPositivo(this.celular.getPreco()) && resultado;
        resultado = valorPositivo(this.celular.getValor()) && resultado;
        resultado = verificadorDeCliente(this.celular.getIdCliente()) && resultado;


        return resultado;
    }

    //Nome deve possuir no mínimo 3 letras
    public Boolean nomePeloMenos3Letras (String nome) {
        Boolean resultado = nome.matches("^[A-z]{3}[A-z\s]{0,58}$");
        if (!resultado) {
            erros.add("Nome deve ter pelo menos 3 letras");
        }
        return resultado;
    }
    //preço positivo
    public Boolean precoPositivo(Double preco){
        Boolean resultado = preco.doubleValue() > 0;
        if(!resultado){
            erros.add("O preco deve ser acima de 0");
        }
        return resultado;
    }
    //valor positivo
    public Boolean valorPositivo(Double valor){
        Boolean resultado = valor.doubleValue() > 0;
        if(!resultado){
            erros.add("O valor deve ser acima de 0");
        }
        return resultado;
    }

    //só pode ter regstro para clientes ativos
    public Boolean verificadorDeCliente(Integer id){
        if(clienteRepository.findById(id).isPresent()){
            Boolean ativo = clienteRepository.findById(id).get().getAtivo();
            if (!ativo){
                erros.add("Cliente não está ativo");
            }
            return ativo;
        }else {
            erros.add("Cliente não existe no sistema");
            return false;
        }
    }

}
