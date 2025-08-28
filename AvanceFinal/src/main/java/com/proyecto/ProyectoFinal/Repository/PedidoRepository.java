package com.proyecto.ProyectoFinal.Repository;

import com.proyecto.ProyectoFinal.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Ya tienes: findAll(), save(), findById(), deleteById(), etc.
}
