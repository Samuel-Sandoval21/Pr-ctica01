/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.practica01.demo.service;

import com.practica01.demo.model.Arbol;
import com.practica01.demo.repository.ArbolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class ArbolService {
 
    @Autowired
    private ArbolRepository arbolRepository;
 
    public List<Arbol> listar() {
        return arbolRepository.findAll();
    }
 
    public void guardar(Arbol arbol) {
        arbolRepository.save(arbol);
    }
 
    public Arbol buscarPorId(Long id) {
        return arbolRepository.findById(id).orElse(null);
    }
 
    public void eliminar(Long id) {
        arbolRepository.deleteById(id);
    }
}
 
