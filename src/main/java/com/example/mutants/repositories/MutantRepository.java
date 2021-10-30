package com.example.mutants.repositories;

/*
Por ahora, no le daremos uso al repositorio, ya que es la capa de la API REST encargada de comunicarse
con la base de datos, la cual no es necesaria hasta la siguiente iteración. A pesar de lo mencionado, me
pareció necesario dejar constancia de este paquete ya que un buen diseño de API REST requiere que exista.
*/

import com.example.mutants.domain.Mutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MutantRepository extends JpaRepository<Mutant, Long> {
}
