package com.example.bakingapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recipe")
public class Recipe {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "recipe_id")
    private int recipeId;

    private String image;
    private String name;
    private int servings;

    public Recipe(int recipeId, String image, String name, int servings) {
        this.recipeId = recipeId;
        this.image = image;
        this.name = name;
        this.servings = servings;
    }

    public int getRecipeId() {
        return this.recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getServings() {
        return this.servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
