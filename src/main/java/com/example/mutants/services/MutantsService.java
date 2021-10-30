package com.example.mutants.services;

import com.example.mutants.domain.Mutant;
import com.example.mutants.repositories.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class MutantsService {

    @Autowired
    private MutantRepository mutantRepository;

    /*
    Por ahora, dejaré solo el método isMutant en el servicio, ya que es el único que necesitamos para llevar
    a cabo la funcionalidad requerida para esta iteración.
    */

    public boolean isMutant(Mutant mutante) {

       List<String> adn = mutante.getAdn();
       mutante.setAdnPersistido(adn.toString());
       mutantRepository.save(mutante);

       /*
        TRANSFORMAMOS EL ARRAY DE STRINGS EN UNA MATRIZ PARA FACILITAR EL TRABAJO
        */

       char matriz[][] = new char[adn.size()][adn.size()];
       for (int i = 0; i < adn.size(); i++) {
           String c = adn.get(i);
           for (int j = 0; j < c.length(); j++) {
               matriz[i][j] = c.charAt(j);
           }
       }

       boolean bandera = false; //Boleano para registrar el resultado del test
       int contador = 0; //Aquí acumularé todas las coincidencias de 4 letras seguidas en cualquier direccion

       for (int i = 0; i < adn.size(); i++) { //RECORRE HORIZONTALMENTE
           for (int j = 0; j < adn.size() - 3; j++) {
               if (matriz[i][j] == matriz[i][j + 1] && matriz[i][j] == matriz[i][j + 2] && matriz[i][j] == matriz[i][j + 3]) {
                   contador++;
               }
           }
       }

       for (int i = 0; i < adn.size() - 3; i++) { //RECORRE VERTICALMENTE
           for (int j = 0; j < adn.size(); j++) {
               if (matriz[i][j] == matriz[i + 1][j] && matriz[i][j] == matriz[i + 2][j] && matriz[i][j] == matriz[i + 3][j]) {
                   contador++;
               }
           }
       }

       for (int i = 0; i < adn.size() - 3; i++) { //RECORRE DIAGONALES
           for (int j = 0; j < adn.size() - 3; j++) {
               if (matriz[i][j] == matriz[i + 1][j + 1] && matriz[i][j] == matriz[i + 2][j + 2] && matriz[i][j] == matriz[i + 3][j + 3]) {
                   contador++;
               }
           }

       }

       for (int i = 0; i < adn.size() - 3; i++) { //RECORRE DIAGONALES INVERSAS
           for (int j = 3; j < adn.size(); j++) {
               if (matriz[i][j] == matriz[i + 1][j - 1] && matriz[i][j] == matriz[i + 2][j - 2] && matriz[i][j] == matriz[i + 3][j - 3]) {
                   contador++;
               }
           }
       }

       if (contador > 1) { //En el caso de encontrarse más de una coincidencia, estamos ante un mutante
           bandera = true;
       }
       return bandera;
   }
}

