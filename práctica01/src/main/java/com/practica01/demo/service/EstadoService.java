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
 
    // Listar todos los estados

    public List<Estado> listar() {

        return estadoRepository.findAll();

    }
 
    // Guardar un estado nuevo o actualizado

    public void guardar(Estado estado) {

        estadoRepository.save(estado);

    }
 
    // Buscar un estado por ID

    public Estado buscarPorId(Long id) {

        return estadoRepository.findById(id).orElse(null);

    }
 
    // Eliminar un estado por ID

    public void eliminar(Long id) {

        estadoRepository.deleteById(id);

    }

}

 