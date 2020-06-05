package com.example.bakingapp.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class RecipeWithSteps {
    @Embedded public Recipe recipe;
    @Relation(
            parentColumn = "id",
            entityColumn = "recipe_id"
    )
    public List<Step> steps;
}
