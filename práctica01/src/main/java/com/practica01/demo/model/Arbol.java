package com.practica01.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.Data;

@Entity
@Data
@Table(name = "arbol")
public class Arbol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    private Long idArbol;

    @Column(name = "nombre_comun", nullable = false, length = 150)
    private String nombreComun;

    @Column(name = "tipo_flor", length = 100)
    private String tipoFlor;

    @Column(name = "dureza_madera", length = 50)
    private String durezaMadera;

    @Column(name = "altura_promedio", precision = 6, scale = 2)
    private BigDecimal alturaPromedio;

    @Column(name = "edad_promedio")
    private Integer edadPromedio;

    @Column(name = "ruta_imagen", length = 255)
    private String rutaImagen;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
}
