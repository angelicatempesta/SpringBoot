package com.example.Prova1.model;

public class Meal {
    private Long id;
    private String name;
    private String description;
    private double price;
    private boolean isWinterMeal;

    public Meal(String name) {
        this.name = name;
    }

    public Meal(String name, String description, double price, boolean isWinterMeal) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isWinterMeal = isWinterMeal;
    }

    public Meal(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isWinterMeal() {
        return isWinterMeal;
    }

    public void setWinterMeal(boolean winterMeal) {
        isWinterMeal = winterMeal;
    }
}
