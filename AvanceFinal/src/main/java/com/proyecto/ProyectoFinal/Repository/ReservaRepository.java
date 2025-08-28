package com.proyecto.ProyectoFinal.Repository;

import com.proyecto.ProyectoFinal.Model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Métodos CRUD automáticos con JPA
}
