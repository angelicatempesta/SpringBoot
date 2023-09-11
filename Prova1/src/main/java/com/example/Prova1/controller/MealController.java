package com.example.Prova1.controller;

import com.example.Prova1.model.Meal;
import com.example.Prova1.service.MealService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MealController {
    private MealService mealService;
    @Autowired
    public MealController(MealService mealService){
        this.mealService = mealService;
    }
    @GetMapping(value= "/get/meals")
    public ResponseEntity<List<Meal>> getMeals(){
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PostMapping(value = "/post/meal")
    public ResponseEntity<String> addMeal(@RequestBody Meal meal){
        mealService.addMeal(meal);
        return ResponseEntity.ok("Meal added!");
    }
    @DeleteMapping(value = "/delete/meal/{id}")
    public ResponseEntity<String> deleteMeal(@PathVariable("id")long id){
        mealService.deleteMeal(id);
        return ResponseEntity.ok("Meal deleted!");
    }
    @PutMapping("/update/meal/{id}")
    public ResponseEntity<String> updateMeal(@PathVariable("id") long id, @RequestBody Meal meal){
        mealService.updateMeal(id,meal);
        return ResponseEntity.ok().body("Meal updated!");
    }
    @GetMapping("/winter-meal")
    public ResponseEntity<List<Meal>> getWinterMeals() throws UnirestException {
        return ResponseEntity.ok(mealService.getWinterMeals());
    }
}
