package com.example.bakingapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import com.example.bakingapp.model.RecipeIngredientCrossRef;

@Dao
public interface RecipeIngredientCrossRefDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertRecipeIngredientCrossRef(RecipeIngredientCrossRef recipeIngredientCrossRef);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateRecipeIngredientCrossRef(RecipeIngredientCrossRef recipeIngredientCrossRef);

    @Delete
    void deleteRecipeIngredientCrossRef(RecipeIngredientCrossRef recipeIngredientCrossRef);
}
