package com.example.comerciodecelularvesp.repositories;

import com.example.comerciodecelularvesp.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByAtivo(Boolean ativo);
}
