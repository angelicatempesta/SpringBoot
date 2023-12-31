package com.example.Prova1.controllerPrimiEsercizi;

import com.example.Prova1.model.Meal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class mealControllerEsercizio2 {
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

    @GetMapping("meal/description-match/{phrase}")
    public Meal mealDescription(@PathVariable("phrase") String f){
        List<Meal> mealList = new ArrayList<>();
        mealList.add(new Meal("Pasta al Pesto", "buonissima pasta al pesto di basilico"));
        mealList.add(new Meal("Pasta all'Arrabbiata", "eccellente pasta piccantissima"));
        mealList.add(new Meal("Impepata di cozze", "ottime cozze fresche di Ischia"));
        mealList.add(new Meal("Pollo alla Piastra", "pollo Aia buonissimo ricco di proteine"));

        for (Meal m : mealList) {
            if (m.getDescription().contains(f)) {
                return m;
            }
        }
        return null;
    }

    @GetMapping("meal/price")
    public List<Meal> mealPrice(@RequestParam("min") double min,@RequestParam("max") double max){
        List<Meal> mealList = new ArrayList<>();
        mealList.add(new Meal("Pasta al Pesto", 12.00));
        mealList.add(new Meal("Pasta all'Arrabbiata", 9.00));
        mealList.add(new Meal("Impepata di cozze", 25.00));
        mealList.add(new Meal("Pollo alla Piastra", 8.50));

        List<Meal> mealListWithPrice = new ArrayList<>();

        for (Meal m : mealList) {
            if (m.getPrice() >= min && m.getPrice() <= max) {
               mealListWithPrice.add(m);
            }
        }
        return mealListWithPrice;
    }
}
