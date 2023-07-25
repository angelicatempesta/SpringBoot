package com.example.Prova1;

public class Meal {
    private String name;
    private String description;
    private double price;

    public Meal(String name) {
        this.name = name;
    }

    public Meal(String name, String description) {
        this.name = name;
        this.description = description;
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
}
