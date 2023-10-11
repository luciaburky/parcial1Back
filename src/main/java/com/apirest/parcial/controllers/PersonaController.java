package com.apirest.parcial.controllers;
import com.apirest.parcial.entities.Persona;
import com.apirest.parcial.services.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
// permitimos el acceso o no desde distintos origenes
// con el * indicamos q podemos acceder desde varios clientes a la API
@RequestMapping(path = "api/v1/personas")
// con esa URL vamos a acceder a los metodos de persona
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{

    // creamos metodo q va a consumir el servicio
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, intente más tarde\"}");
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, intente más tarde\"}");
        }
    }

}
