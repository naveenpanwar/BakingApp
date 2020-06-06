package com.example.bakingapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.bakingapp.model.Recipe;
import com.example.bakingapp.model.RecipeWithIngredients;

import java.util.List;

@Dao
public interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertRecipe(Recipe recipe);

    @Insert
    long[] insertRecipes(Recipe... recipes);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateRecipe(Recipe recipe);

    @Delete
    void deleteRecipe(Recipe recipe);

    @Transaction
    @Query("SELECT * FROM recipe")
    LiveData<List<RecipeWithIngredients>> getRecipesWithIngredients();

    @Query("SELECT * FROM recipe")
    LiveData<List<Recipe>> getRecipes();

    @Transaction
    @Query("SELECT * FROM recipe WHERE recipe_id = :recipe_id")
    RecipeWithIngredients getIngredients(long recipe_id);
}
