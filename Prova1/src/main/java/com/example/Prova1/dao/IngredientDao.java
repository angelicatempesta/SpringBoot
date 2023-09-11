package com.example.Prova1.dao;

import com.example.Prova1.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface IngredientDao extends JpaRepository <Ingredient, Long> {
}
