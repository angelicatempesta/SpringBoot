package com.example.Prova1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class mealController {
    @GetMapping("/meals")
    public List<Meal> mealList(){
        List<Meal> mealList = new ArrayList<>();
        mealList.add(new Meal ("Pasta al Pesto"));
        mealList.add(new Meal ("Pennette all'Arrabbiata"));
        mealList.add(new Meal ("Impepata di cozze"));
        mealList.add(new Meal ("Pollo alla Piastra"));

        return mealList;
    }
}
