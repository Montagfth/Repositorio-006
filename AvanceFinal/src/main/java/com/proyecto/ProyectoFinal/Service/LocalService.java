package com.proyecto.ProyectoFinal.Service;

import com.proyecto.ProyectoFinal.Model.Local;
import java.util.List;

public interface LocalService {
    List<Local> listarLocales();
    Local guardar(Local local);
}
