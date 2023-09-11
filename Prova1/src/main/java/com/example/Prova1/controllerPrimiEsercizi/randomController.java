package com.example.Prova1.controllerPrimiEsercizi;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class randomController {
    @GetMapping("/random")
    public ResponseEntity<?> randomResponse(){
        return (new Random().nextBoolean() ? new ResponseEntity<>(HttpStatusCode.valueOf(200)) : new ResponseEntity<>(HttpStatusCode.valueOf(400)));
    }
}
