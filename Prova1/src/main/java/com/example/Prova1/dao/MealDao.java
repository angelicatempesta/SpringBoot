package com.example.Prova1.dao;


import com.example.Prova1.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MealDao extends JpaRepository <Meal, Long> {

List<Meal> findByIsWinterMeal(boolean isWinterMeal);
}
