package com.example.Prova1.service;

import com.example.Prova1.model.Meal;
import com.example.Prova1.dao.MealDao;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MealService {

    private MealDao mealDao;
    private final Double MAX_WINTER_TEMP = 10.0;

    @Autowired
    public MealService(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public void addMeal(Meal meal) {
        if (meal == null) throw new IllegalArgumentException("Meal cannot be null!");
        if (meal.getName() == null || meal.getName().isEmpty())
            throw new IllegalArgumentException("Meal name cannot be null or empty!");
        if (meal.getDescription() == null || meal.getDescription().isEmpty())
            throw new IllegalArgumentException("Meal description cannot be null or empty!");
        if (meal.getPrice() <= 0) throw new IllegalArgumentException("Meal price cannot be less than or equal to 0!");
        if (meal.getPrice() > 100) throw new IllegalArgumentException("Meal price cannot be greater than 100!");
        mealDao.save(meal);
    }

    public void deleteMeal(long id) {
        mealDao.deleteById(id);

    }

    public void updateMeal(long id, Meal meal) {
        if(mealDao.findById(id).equals(meal.getId()) && mealDao.findById(id).isPresent()){
            mealDao.getReferenceById(id).setName(meal.getName());
            mealDao.getReferenceById(id).setDescription(meal.getDescription());
            mealDao.getReferenceById(id).setPrice(meal.getPrice());
            mealDao.getReferenceById(id).setWinterMeal(meal.isWinterMeal());
        }
    }

    public List<Meal> getMeals() {
        return mealDao.findAll();
    }

    public List<Meal> getWinterMeals() throws UnirestException {
        Double currentTemperatureInCentigrade = getCurrentTemperatureInCentigrade();
        if(currentTemperatureInCentigrade > MAX_WINTER_TEMP) return new ArrayList<>();
        return mealDao.findByIsWinterMeal(true);
    }

    public Double getCurrentTemperatureInCentigrade() throws UnirestException {
        try {
            JSONObject response =
                    Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=42.8333&longitude=12.8333&hourly=temperature_2m").asJson().getBody().getObject();
            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
