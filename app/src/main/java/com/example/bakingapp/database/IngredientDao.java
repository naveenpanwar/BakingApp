package com.example.bakingapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.bakingapp.model.Ingredient;
import com.example.bakingapp.model.IngredientWithRecipes;
import com.example.bakingapp.model.RecipeWithIngredients;

import java.util.List;

@Dao
public interface IngredientDao {
    @Insert
    long insertIngredient(Ingredient ingredient);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertIngredients(Ingredient... ingredients);

    @Update
    void updateIngredient(Ingredient ingredient);

    @Delete
    void deleteIngredient(Ingredient ingredient);

    @Transaction
    @Query("SELECT * FROM ingredient")
    List<IngredientWithRecipes> getIngredientWithRecipes();

    @Transaction
    @Query("SELECT * FROM ingredient WHERE ingredient_id = :ingredient_id")
    IngredientWithRecipes getRecipes(long ingredient_id);
}
