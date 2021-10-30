package com.example.mutants;

import com.example.mutants.domain.Mutant;
import com.example.mutants.services.MutantsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MutantsTest {

    public MutantsService mutantsService;
    public boolean resultado;

    @BeforeEach
    public void mut(){
        mutantsService = new MutantsService();
    }

    @Test
    public void mutantTestVertical() {

        List<String> adn = new ArrayList<String>(List.of("TTGCGA","TAGTGC","TTATGT","TGAAGG","CGCCTA","TCACTG"));
        Mutant mutant = new Mutant();
        mutant.setAdn(adn);
        resultado = mutantsService.isMutant(mutant);
        Assertions.assertTrue(resultado);
        System.out.println("El resultado del test es: "+ resultado);
    }

    @Test
    public void mutantTestHorizontal() {

        List<String> adn = new ArrayList<String>(List.of("TTGCGA","TAGTGC","TTTTGT","TGAAGG","CGCCCC","TCACTG"));
        Mutant mutant = new Mutant();
        mutant.setAdn(adn);
        resultado = mutantsService.isMutant(mutant);
        Assertions.assertTrue(resultado);
        System.out.println("El resultado del test es: "+ resultado);
    }

    @Test
    public void mutantTestDiagonal(){

        List<String> adn = new ArrayList<String>(List.of("TTGCGA","TAGTGC","TTATGT","TGAAGG","CGCCTA","TCACTG"));
        Mutant mutant = new Mutant();
        mutant.setAdn(adn);
        resultado = mutantsService.isMutant(mutant);
        Assertions.assertTrue(resultado);
        System.out.println("El resultado del test es: "+ resultado);
    }

    @Test
    public void mutantTestContradiagonal(){

        List<String> adn = new ArrayList<String>(List.of("TTGCGA","TAGTGC","TTATGT","TGTAGG","CGCTTA","TCCCCG"));
        Mutant mutant = new Mutant();
        mutant.setAdn(adn);
        resultado = mutantsService.isMutant(mutant);
        Assertions.assertTrue(resultado);
        System.out.println("El resultado del test es: "+ resultado);
    }

    /*@Test
    public void mutantTestVacío(){

        List<String> adn = new ArrayList<String>(List.of("TTGCGA","TAATGC","TTAAGT","TGAAAG","CGCCTA","TCCCCG"));
        Mutant mutant = new Mutant();
        mutant.setAdn(adn);
        resultado = mutantsService.isMutant(mutant);
        Assertions.assertFalse(resultado);
        System.out.println("El resultado del test es: "+ resultado);
    }*/
}
