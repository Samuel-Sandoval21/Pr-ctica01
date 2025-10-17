/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.practica01.demo.controller;
import com.practica01.demo.model.Arbol;
import com.practica01.demo.service.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 

/**
 *
 * @author HP
 */

@Controller
public class ArbolController {
   @Autowired
    private ArbolService arbolService;
 
    // -------------------------------
    // LISTADO DE ÁRBOLES
    // -------------------------------
    @GetMapping("/arboles")
    public String listarArboles(Model model) {
        List<Arbol> lista = arbolService.listar();
        model.addAttribute("arboles", lista);
        return "list"; // templates/list.html
    }
 
    // -------------------------------
    // FORMULARIO PARA AGREGAR UN ÁRBOL
    // -------------------------------
    @GetMapping("/arboles/nuevo")
    public String mostrarFormulario(Arbol arbol) {
        return "form"; // templates/form.html
    }
 
    // -------------------------------
    // GUARDAR NUEVO ÁRBOL
    // -------------------------------
    @PostMapping("/arboles/guardar")
    public String guardarArbol(@ModelAttribute("arbol") Arbol arbol) {
        arbolService.guardar(arbol);
        return "redirect:/arboles";
    }
 
    // -------------------------------
    // FORMULARIO PARA EDITAR UN ÁRBOL EXISTENTE
    // -------------------------------
    @GetMapping("/arboles/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Arbol arbol = arbolService.buscarPorId(id);
        model.addAttribute("arbol", arbol);
        return "form"; // templates/form.html
    }
 
    // -------------------------------
    // ELIMINAR UN ÁRBOL
    // -------------------------------
    @GetMapping("/arboles/eliminar/{id}")
    public String eliminarArbol(@PathVariable("id") Long id) {
        arbolService.eliminar(id);
        return "redirect:/arboles";
    }
}


