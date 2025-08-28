package com.proyecto.ProyectoFinal.Repository;

import com.proyecto.ProyectoFinal.Model.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
    // Puedes agregar métodos personalizados si los necesitas
}
