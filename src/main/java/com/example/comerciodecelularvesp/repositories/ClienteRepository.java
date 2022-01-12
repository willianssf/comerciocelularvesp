package com.example.comerciodecelularvesp.repositories;
import com.example.comerciodecelularvesp.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByAtivo(Boolean ativo);
}
