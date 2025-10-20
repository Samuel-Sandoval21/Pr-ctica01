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
 
    // Listar todos los árboles
    public List<Arbol> listar() {
        return arbolRepository.findAll();
    }
 
    // Guardar un árbol nuevo o actualizado
    public void guardar(Arbol arbol) {
        arbolRepository.save(arbol);
    }
 
    // Buscar por ID
    public Arbol buscarPorId(Long id) {
        return arbolRepository.findById(id).orElse(null);
    }
 
    // Eliminar por ID
    public void eliminar(Long id) {
        arbolRepository.deleteById(id);
    }
}