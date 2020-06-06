package com.example.bakingapp.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bakingapp.database.RecipeDatabase;

import java.util.List;

public class RecipeViewModel extends AndroidViewModel {
    private LiveData<List<RecipeWithIngredients>> recipesWithIngredients;
    private LiveData<List<Recipe>> recipes;

    public RecipeViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<RecipeWithIngredients>> getRecipesWithIngredients() {
        if( recipesWithIngredients == null ) {
            loadRecipesWithIngredients();
        }
        return recipesWithIngredients;
    }

    public void loadRecipesWithIngredients() {
        RecipeDatabase db = RecipeDatabase.getInstance(getApplication());
        recipesWithIngredients = db.recipeDao().getRecipesWithIngredients();
    }

    public LiveData<List<Recipe>> getRecipes() {
        if( recipes == null ) {
            loadRecipes();
        }
        return recipes;
    }

    public void loadRecipes() {
        RecipeDatabase db = RecipeDatabase.getInstance(getApplication());
        recipes = db.recipeDao().getRecipes();
    }
}
