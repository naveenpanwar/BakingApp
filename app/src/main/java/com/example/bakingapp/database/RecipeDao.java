package com.example.bakingapp.database;

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
    @Insert
    long insertRecipe(Recipe recipe);

    @Insert
    long[] insertRecipes(Recipe... recipes);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateRecipe(Recipe recipe);

    @Delete
    void deleteRecipe(Recipe recipe);

    @Transaction
    @Query("SELECT * FROM recipe")
    List<RecipeWithIngredients> getRecipeWithIngredients();

    @Transaction
    @Query("SELECT * FROM recipe WHERE id = :recipe_id")
    RecipeWithIngredients getIngredients(long recipe_id);
}
