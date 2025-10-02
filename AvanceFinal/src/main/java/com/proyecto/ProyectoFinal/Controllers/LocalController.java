package com.proyecto.ProyectoFinal.Controllers;

// Modificacion en el paquete: Controller -> Controllers
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.ProyectoFinal.Model.Local;
import com.proyecto.ProyectoFinal.Service.LocalService;

@Controller
public class LocalController {

    private final LocalService localService;

    public LocalController(LocalService localService) {
        this.localService = localService;
    }

    @GetMapping("/locales")
    public String mostrarLocales(Model model) {
        // Lista de locales para la vista
        List<Local> locales = localService.listarLocales();
        model.addAttribute("locales", locales);

        // También agrega el objeto para el formulario de reserva para evitar error
        model.addAttribute("reserva", new com.proyecto.ProyectoFinal.Model.Reserva());

        return "locales"; // Thymeleaf template que usas
    }
}
