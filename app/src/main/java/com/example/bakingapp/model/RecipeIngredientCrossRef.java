package com.example.bakingapp.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

@Entity(primaryKeys = {"recipe_id","ingredient_id"})
public class RecipeIngredientCrossRef {
    public long recipe_id;
    public long ingredient_id;

    public RecipeIngredientCrossRef(long recipe_id, long ingredient_id) {
        this.recipe_id = recipe_id;
        this.ingredient_id = ingredient_id;
    }

    public long getId() {
        return recipe_id;
    }

    public void setId(long id) {
        this.recipe_id = id;
    }

    public long getIngredientId() {
        return ingredient_id;
    }

    public void setIngredientId(long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }
}
