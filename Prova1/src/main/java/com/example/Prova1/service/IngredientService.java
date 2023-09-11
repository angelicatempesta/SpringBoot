package com.example.Prova1.service;

import com.example.Prova1.model.Ingredient;
import com.example.Prova1.dao.IngredientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    private IngredientDao daoIng;
@Autowired
    public IngredientService(IngredientDao daoIng) {
        this.daoIng = daoIng;
    }

    public void addIngredient(Ingredient i){
    daoIng.save(i);
    }
    public List<Ingredient> retrieveIngredients(){
    return daoIng.findAll();
    }

    public void updateIngredient(long id, Ingredient ingredient){
        Optional<Ingredient> ingTemp = daoIng.findById(id);
    if(ingredient.getId().equals(id) && ingTemp.isPresent()){
        ingTemp.get().setName(ingredient.getName());
        ingTemp.get().setGlutenFree(ingredient.isGlutenFree());
        ingTemp.get().setVegetarian(ingredient.isVegetarian());
        ingTemp.get().setVegan(ingredient.isVegan());
        ingTemp.get().setLactoseFree(ingredient.isLactoseFree());
        daoIng.save(ingredient);
    }
    }

    public void deleteIngredient(long id){
    if (daoIng.existsById(id)){
        daoIng.deleteById(id);
    }
    }
}
