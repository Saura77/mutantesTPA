package com.example.mutants.domain;

import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
Por ahora, declararemos la clase Mutant para proyectarla a ser la clase a persistir en la siguiente
iteración, por ahora declararé solo el atributo adn junto con la etiqueta de Lombock Data.
 */

@Entity
@Table(name = "mutants")
@Data
public class Mutant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "adn")
    private String adnPersistido;

    //Este atributo es usado para trabajar la detección del mutante en el adn, no se persiste
    @Transient
    private List<String> adn;
}
