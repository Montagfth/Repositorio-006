package com.pizza.pizzeriaBackend.repository;

import com.pizza.pizzeriaBackend.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByLocalId(Long localId);
}