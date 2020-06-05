package com.example.bakingapp.model;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class RecipeWithIngredients {
    @Embedded
    public Recipe recipe;

    @Relation(
            parentColumn = "id",
            entityColumn = "ingredient_id",
            associateBy = @Junction(RecipeWithIngredients.class)
    )
    public List<Ingredient> ingredients;
}
