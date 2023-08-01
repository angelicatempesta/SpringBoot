package com.example.Prova1.dao;

import com.example.Prova1.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealDao {
    private List<Meal> meals = new ArrayList<>();

    public void addMeal(Meal meal){
        this.meals.add(meal);
    }

    public void deleteMeal(String mealName){
        this.meals.removeIf(m -> m.getName().equals(mealName));
    }

    public void updateMeal(Meal meal){
        this.meals.removeIf(m -> m.getName().equals(meal.getName()));
        this.meals.add(meal);
    }

    public List<Meal> getMeals(){
        return this.meals;
    }

}
