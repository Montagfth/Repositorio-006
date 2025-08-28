package com.proyecto.ProyectoFinal.Controllers;

import com.proyecto.ProyectoFinal.Model.Contacto;
import com.proyecto.ProyectoFinal.Repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    @GetMapping("/contactanos")
    public String mostrarContacto(
            Model model,
            @RequestParam(defaultValue = "0") int page
    ) {
        model.addAttribute("contacto", new Contacto());

        // Paginacion de 5 mensajes por página
        Page<Contacto> contactos = contactoRepository.findAll(PageRequest.of(page, 5));
        model.addAttribute("contactos", contactos);

        model.addAttribute("paginaActual", page);

        // Puedes agregar mensajeExito solo si lo necesitas
        return "contactanos";
    }

    @PostMapping("/contacto/guardar")
    public String guardarContacto(
            @ModelAttribute("contacto") @Valid Contacto contacto,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            // Si hay errores, vuelve a cargar la lista de contactos y la página
            Page<Contacto> contactos = contactoRepository.findAll(PageRequest.of(0, 5));
            model.addAttribute("contactos", contactos);
            model.addAttribute("paginaActual", 0);
            return "contactanos";
        }

        contactoRepository.save(contacto);
        model.addAttribute("mensajeExito", "¡Mensaje enviado correctamente!");

        // Usar redirect para evitar re-envío en F5, puedes usar redirect y flashattribute si prefieres
        return "redirect:/contactanos";
    }

    // Opcional: Métodos para editar y eliminar... (según los enlaces de tu html)
    @GetMapping("/contacto/eliminar")
    public String eliminarContacto(@RequestParam("id") Long id) {
        contactoRepository.deleteById(id);
        return "redirect:/contactanos";
    }

    @GetMapping("/contacto/editar")
    public String editarContacto(@RequestParam("id") Long id, Model model) {
        Contacto contacto = contactoRepository.findById(id).orElse(null);
        if (contacto == null) return "redirect:/contactanos";
        model.addAttribute("contacto", contacto);
        // paginación y lista de mensajes actual
        Page<Contacto> contactos = contactoRepository.findAll(PageRequest.of(0, 5));
        model.addAttribute("contactos", contactos);
        model.addAttribute("paginaActual", 0);
        return "contactanos"; // reutiliza misma vista si deseas
    }
}
