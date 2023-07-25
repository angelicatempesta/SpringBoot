package com.example.Prova1;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class helloController {

    @GetMapping("/hello")
    public String response(){
        return "Hello World!";
    }

}
