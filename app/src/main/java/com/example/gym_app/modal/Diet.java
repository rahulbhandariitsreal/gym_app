package com.example.gym_app.modal;

import java.util.ArrayList;

// Define the Diet class
public class Diet {
    private String name;
    private String description;
    private ArrayList<String> foods;

    public Diet(String name, String description, ArrayList<String> foods) {
        this.name = name;
        this.description = description;
        this.foods = foods;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getFoods() {
        return foods;
    }
}
