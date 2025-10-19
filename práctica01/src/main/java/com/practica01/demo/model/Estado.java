package com.practica01.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Long idEstado;

    @Column(name = "nombre_estado", nullable = false, length = 100)
    private String nombreEstado;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Arbol> arboles;
}
