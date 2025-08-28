package com.proyecto.ProyectoFinal.Controllers;

import com.proyecto.ProyectoFinal.Model.Reserva;
import com.proyecto.ProyectoFinal.Repository.ReservaRepository;
import com.proyecto.ProyectoFinal.Service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private LocalService localService;

    @PostMapping("/reservas/guardar")
    public String guardarReserva(
            @ModelAttribute("reserva") @Valid Reserva reserva,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            // Asegúrate de volver a cargar la lista de locales si la necesitas en la vista de error
            model.addAttribute("locales", localService.listarLocales());
            return "locales";
        }

        reservaRepository.save(reserva);
        // Si quieres mandar un mensaje de éxito, puedes usar flash attributes o simplemente redirigir.
        return "redirect:/locales";
    }
}
