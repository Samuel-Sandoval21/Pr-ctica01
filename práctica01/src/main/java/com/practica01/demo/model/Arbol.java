/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.practica01.demo.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "arbol")

public class Arbol {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_arbol;
 
    private String nombre_comun;
    private String tipo_flor;
    private String dureza_madera;
    private Double altura_promedio;
    private Integer edad_promedio;
    private String ruta_imagen;
 
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
}

