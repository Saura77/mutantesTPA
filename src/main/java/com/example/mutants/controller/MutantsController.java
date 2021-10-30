package com.example.mutants.controller;

import com.example.mutants.services.MutantsService;
import com.example.mutants.domain.Mutant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/mutant")
public class MutantsController {

    @Autowired
    private MutantsService mutantsService;

    private int contMutante = 0;
    private int contHumano = 0;

    /*
    Metodo POST solicitado. Recibe una request en formato JSON con una entidad mutante, el cual se comunicará con
    el servicio, transfiriendo dicha instancia como argumento, y esperando una respuesta.
    */

   @PostMapping("")
    public ResponseEntity<?> verificacionAdn(@RequestBody Mutant mutante){
        try{
            if (mutantsService.isMutant(mutante)){
                contMutante++;
                return ResponseEntity.status(HttpStatus.OK).body(""); //Si se comprueba mutante, retorna estado OK
            }else{
                contHumano++;
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(""); //Si no es mutante, retorna estado FORBIDDEN
            }
        }catch(Exception e){ //Bloque try catch encargado de mostrar un error en caso de que falle la comunicación con el servicio
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/stats")
    public ResponseEntity stats(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body("{\"count_mutant_dna\":"+contMutante+"{\"count_human_dna\":"+contHumano+"{\"ratio\":"+contMutante/contHumano);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }
    //"{\"count_mutant_dna\":"+contMutante+"{\"count_human_dna\":"+contHumano+"{\"ratio\":"+contMutante/contHumano
}
