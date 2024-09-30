package com.example.inicial1.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="libro")
@AllArgsConstructor
@NoArgsConstructor //constructor vacio
@Setter
@Getter
@Builder
@Audited
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private int fecha;
    private String genero;
    private int paginas;


    @ManyToMany(cascade =CascadeType.REFRESH, mappedBy = "libros")
    @Builder.Default
    private List<Autor> autores = new ArrayList<Autor>();


    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="fk_persona")
    private Persona persona;
}
