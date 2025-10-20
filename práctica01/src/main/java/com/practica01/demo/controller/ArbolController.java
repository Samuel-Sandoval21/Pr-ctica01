/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.practica01.demo.controller;
 
import com.practica01.demo.model.Arbol;
import com.practica01.demo.model.Estado;
import com.practica01.demo.service.ArbolService;
import com.practica01.demo.service.EstadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
 
@Controller
@RequestMapping("/arboles")
public class ArbolController {
 
    @Autowired
    private ArbolService arbolService;
 
    @Autowired
    private EstadoService estadoService;
 
    // -------------------------------
    // LISTAR ARBOLES
    // -------------------------------
    @GetMapping
    public String listarArboles(Model model) {
        List<Arbol> lista = arbolService.listar();
        model.addAttribute("arboles", lista);
        return "list"; // templates/list.html
    }
 
    // -------------------------------
    // FORMULARIO NUEVO ARBOL
    // -------------------------------
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        Arbol arbol = new Arbol();
        List<Estado> estados = estadoService.listar();
        model.addAttribute("arbol", arbol);
        model.addAttribute("estados", estados);
        return "form"; // templates/form.html
    }
 
    // -------------------------------
    // GUARDAR ARBOL
    // -------------------------------
    @PostMapping("/guardar")
    public String guardarArbol(@ModelAttribute("arbol") Arbol arbol) {
        arbolService.guardar(arbol);
        return "redirect:/arboles";
    }
 
    // -------------------------------
    // FORMULARIO EDITAR ARBOL
    // -------------------------------
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Arbol arbol = arbolService.buscarPorId(id);
        if (arbol == null) {
            return "redirect:/arboles";
        }
        List<Estado> estados = estadoService.listar();
        model.addAttribute("arbol", arbol);
        model.addAttribute("estados", estados);
        return "form";
    }
 
    // -------------------------------
    // ELIMINAR ARBOL
    // -------------------------------
    @GetMapping("/eliminar/{id}")
    public String eliminarArbol(@PathVariable("id") Long id) {
        arbolService.eliminar(id);
        return "redirect:/arboles";
    }
}
