package com.proyecto.ProyectoFinal.Controllers;

import com.proyecto.ProyectoFinal.Model.RegistroDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controladores {

    @GetMapping("/")
    public String rootRedirect() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        // Agrega aquí los atributos que usa tu vista index.html
        model.addAttribute("registroDTO", new RegistroDTO());
        return "index";
    }
}
