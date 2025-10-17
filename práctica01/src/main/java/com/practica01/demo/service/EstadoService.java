/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.practica01.demo.service;

import com.practica01.demo.model.Estado;
import com.practica01.demo.repository.EstadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class EstadoService {
 
    @Autowired
    private EstadoRepository estadoRepository;
 
    public List<Estado> listar() {
        return estadoRepository.findAll();
    }
}
