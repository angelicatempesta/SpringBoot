package com.example.Prova1.controller;


import com.example.Prova1.dao.IngredientDao;
import com.example.Prova1.model.Ingredient;
import com.example.Prova1.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController{
    private IngredientService serviceIng;
@Autowired
    public IngredientController(IngredientService serviceIng) {
        this.serviceIng = serviceIng;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createIngredient(@RequestBody Ingredient i){
    try{
        serviceIng.addIngredient(i);
        return ResponseEntity.ok("Ingrediente aggiunto!");
    } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
}
@GetMapping("/retrieve")
    public ResponseEntity<List<Ingredient>> retrieveIngredient(){
    try{
        return ResponseEntity.ok().body(serviceIng.retrieveIngredients());
    } catch (IllegalArgumentException e){
        return ResponseEntity.notFound().build();
    }
}

@PutMapping("/update/{id}")
    public ResponseEntity<String> updateIngredient(@PathVariable ("id") long id, @RequestBody Ingredient ingredient){
    try{
        serviceIng.updateIngredient(id, ingredient);
        return ResponseEntity.ok().body("Ingrediente aggiunto!");
    } catch (IllegalArgumentException e){
        return ResponseEntity.badRequest().build();
    }
}
@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteIngredient(@PathVariable("id") long id){
    try {
        serviceIng.deleteIngredient(id);
        return ResponseEntity.ok().body("Ingrediente eliminato con successo!");
    } catch (IllegalArgumentException e){
        return ResponseEntity.notFound().build();
    }
}
}
