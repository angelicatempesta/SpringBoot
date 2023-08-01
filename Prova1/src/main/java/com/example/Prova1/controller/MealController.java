package com.example.Prova1.controller;

import com.example.Prova1.Meal;
import com.example.Prova1.service.MealService;
import org.apache.coyote.Response;
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

    @PutMapping(value = "/put/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal){
        mealService.addMeal(meal);
        return ResponseEntity.ok("Meal added!");
    }
    @DeleteMapping(value = "/delete/meal/{mealName}")
    public ResponseEntity<String> deleteMeal(@PathVariable String mealName){
        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("Meal deleted!");
    }
}
