package com.example.Prova1;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class infoController {
    @GetMapping("/info")
    public ResponseEntity<?> infoResponse(){
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
