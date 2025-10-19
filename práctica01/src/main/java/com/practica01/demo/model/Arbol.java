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
    @Column(name = "id_arbol")
    private Long idArbol;
 
    @Column(name = "nombre_comun", nullable = false, length = 100)
    private String nombreComun;
 
    @Column(name = "tipo_flor", length = 100)
    private String tipoFlor;
 
    @Column(name = "dureza_madera", length = 50)
    private String durezaMadera;
 
    @Column(name = "altura_promedio")
    private Double alturaPromedio;
 
    @Column(name = "edad_promedio")
    private Integer edadPromedio;
 
    @Column(name = "ruta_imagen")
    private String rutaImagen;
 
    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;
}
