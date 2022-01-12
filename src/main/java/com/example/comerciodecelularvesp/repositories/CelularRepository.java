package com.example.comerciodecelularvesp.repositories;

import com.example.comerciodecelularvesp.entities.Celular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CelularRepository extends JpaRepository<Celular, Integer> {
    List<Celular> findByAtivo(Boolean ativo);
}