package com.example.comerciodecelularvesp.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", length = 10, nullable = false)
    private Integer id;
    @Column(name = "data", nullable = false, unique = true)
    private Date data;
    @Column(name = "valor", nullable = false, length = 18)
    private Double valor;
    @Column(name = "modelo", nullable = false, length = 80)
    private String modelo;
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    @Column(name = "id_cliente", nullable = false, length = 10)
    private Integer idCliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

}
