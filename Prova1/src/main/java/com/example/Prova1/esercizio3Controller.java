package com.example.Prova1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class esercizio3Controller {
    private List<Meal> mealList = new ArrayList<>();

    @PutMapping(value = "/meal")
    public void addMeal(@RequestBody Meal meal) {
        mealList.add(meal);
    }

    @PostMapping(value = "/meal/{name}")
    public ResponseEntity<?> updateMeal(@PathVariable("/name") String mealName, @RequestBody Meal meal) {
        for (Meal m : mealList) {
            if (m.getName().equals(mealName)) {
                mealList.remove(m);
                mealList.add(meal);
                return ResponseEntity.ok("You updated the meal!");
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/meal/{name}")
    public ResponseEntity<?> deleteMeal(@PathVariable("/name") String mealName) {
        for (Meal m : mealList) {
            if (m.getName().equals(mealName)) {
                mealList.remove(m);
                return ResponseEntity.ok("You deleted the meal!");
            }

        } return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/meal/price/{price}")
    public ResponseEntity<?> deleteMealByPrice(@PathVariable("/price") Double mealPrice) {
        for (Meal m : mealList) {
            if (m.getPrice() > mealPrice) {
                mealList.remove(m);
                return ResponseEntity.ok("You deleted all the meals above a certain price!");
            }

        } return ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/meal/{name}/price")
    public ResponseEntity<?> updateMealPriceByName(@PathVariable("/name") String mealName, @RequestBody Double newPrice){
       for(Meal m : mealList){
           if(m.getName().equals(mealName)){
               m.setPrice(newPrice);
               return ResponseEntity.ok("You correctly updated the price of a certain meal!");
           }
       }
        return ResponseEntity.badRequest().build();
    }
}
