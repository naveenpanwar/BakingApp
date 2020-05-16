package com.example.bakingapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "recipe")
public class Recipe {
    @PrimaryKey
    @NonNull
    private int id;

    private String image;
    private String name;
    private int servings;

    public Recipe(int id, String image, String name, int servings) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.servings = servings;
    }

    public int getId() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }

    public int getServings() {
        return this.servings;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }
}
