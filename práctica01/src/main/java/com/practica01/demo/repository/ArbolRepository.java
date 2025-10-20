package com.practica01.demo.repository;
 
import com.practica01.demo.model.Arbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface ArbolRepository extends JpaRepository<Arbol, Long> {
 
}