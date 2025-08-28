package com.proyecto.ProyectoFinal.Controllers;

import com.proyecto.ProyectoFinal.Model.Evento;
import com.proyecto.ProyectoFinal.Service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("evento", new Evento());
        model.addAttribute("eventos", eventoService.listarTodos());
        return "eventos";
    }

    @PostMapping("/guardar")
    public String guardarEvento(@Valid @ModelAttribute("evento") Evento evento, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("eventos", eventoService.listarTodos());
            return "eventos";
        }
        eventoService.guardar(evento);
        return "redirect:/eventos?exito";
    }
}
