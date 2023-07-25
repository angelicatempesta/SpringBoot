package com.example.Prova1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class mealController {
    @GetMapping("/meals")
    public List<Meal> mealList() {
        List<Meal> mealList = new ArrayList<>();
        mealList.add(new Meal("Pasta al Pesto"));
        mealList.add(new Meal("Pennette all'Arrabbiata"));
        mealList.add(new Meal("Impepata di cozze"));
        mealList.add(new Meal("Pollo alla Piastra"));

        return mealList;
    }


    @GetMapping("/meal/{name}")
    public Meal mealFunction(@PathVariable("name") String n) {
        List<Meal> mealList = new ArrayList<>();
        mealList.add(new Meal("Pasta al Pesto"));
        mealList.add(new Meal("Pasta all'Arrabbiata"));
        mealList.add(new Meal("Impepata di cozze"));
        mealList.add(new Meal("Pollo alla Piastra"));

        for (Meal m : mealList) {
            if (m.getName().contains(n)) {
              return m;
            }
        }
       return null;
    }
}
