package com.proyecto.ProyectoFinal.Controllers;

import com.proyecto.ProyectoFinal.Model.Pedido;
import com.proyecto.ProyectoFinal.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping
    public String mostrarFormularioPedido(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "pedidos";
    }

    @PostMapping
    public String procesarPedido(@ModelAttribute Pedido pedido) {
        pedidoRepository.save(pedido);
        return "redirect:/pedidos?success";
    }
}
