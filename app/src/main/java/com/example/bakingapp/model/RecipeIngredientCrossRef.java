package com.example.bakingapp.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

@Entity(primaryKeys = {"id","ingredient_id"})
public class RecipeIngredientCrossRef {
    public long id;
    public long ingredient_id;

    public RecipeIngredientCrossRef(long id, long ingredient_id) {
        this.id = id;
        this.ingredient_id = ingredient_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIngredientId() {
        return ingredient_id;
    }

    public void setIngredientId(long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }
}
