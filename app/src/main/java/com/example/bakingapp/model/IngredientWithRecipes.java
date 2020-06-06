package com.example.bakingapp.model;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class IngredientWithRecipes {
    @Embedded
    public Ingredient ingredient;

    @Relation(
            parentColumn = "ingredient_id",
            entityColumn = "id",
            associateBy = @Junction(RecipeWithIngredients.class)
    )
    public List<Recipe> recipes;
}
