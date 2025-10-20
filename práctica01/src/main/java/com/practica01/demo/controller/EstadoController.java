package com.practica01.demo.controller;

import com.practica01.demo.model.Estado;
import com.practica01.demo.service.EstadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    // -------------------------------
    // LISTAR ESTADOS
    // -------------------------------
    @GetMapping
    public String listarEstados(Model model) {
        List<Estado> lista = estadoService.listar();
        model.addAttribute("estados", lista);
        return "estado_list"; // templates/estado_list.html
    }

    // -------------------------------
    // FORMULARIO NUEVO ESTADO
    // -------------------------------
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Estado estado) {
        return "estado_form";
    }

    // -------------------------------
    // GUARDAR ESTADO
    // -------------------------------
    @PostMapping("/guardar")
    public String guardarEstado(@ModelAttribute("estado") Estado estado) {
        estadoService.guardar(estado);
        return "redirect:/estados";
    }

    // -------------------------------
    // FORMULARIO EDITAR ESTADO
    // -------------------------------
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Estado estado = estadoService.buscarPorId(id);
        model.addAttribute("estado", estado);
        return "estado_form";
    }

    // -------------------------------
    // ELIMINAR ESTADO
    // -------------------------------
    @GetMapping("/eliminar/{id}")
    public String eliminarEstado(@PathVariable("id") Long id) {
        estadoService.eliminar(id);
        return "redirect:/estados";
    }
}
