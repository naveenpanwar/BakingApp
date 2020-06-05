package com.example.bakingapp.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.bakingapp.model.Ingredient;
import com.example.bakingapp.model.Material;
import com.example.bakingapp.model.Measure;
import com.example.bakingapp.model.Recipe;
import com.example.bakingapp.model.RecipeIngredientCrossRef;
import com.example.bakingapp.model.Step;

@Database(entities = {Measure.class, Material.class, Ingredient.class, Step.class,
        RecipeIngredientCrossRef.class, Recipe.class}, version = 1, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class RecipeDatabase extends RoomDatabase {
    private static final String LOG_TAG = RecipeDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "recipe_database";
    private static RecipeDatabase sInstance;

    public static RecipeDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "creating new database instance");
                sInstance = Room.databaseBuilder(
                        context.getApplicationContext(),
                        RecipeDatabase.class,
                        RecipeDatabase.DATABASE_NAME
                ).build();
            }
        }
        Log.d(LOG_TAG, "getting the database instance");
        return sInstance;
    }

    public abstract MaterialDao materialDao();
    public abstract MeasureDao measureDao();
    public abstract IngredientDao ingredientDao();
    public abstract StepDao stepDao();
    public abstract RecipeIngredientCrossRefDao recipeIngredientCrossRefDao();
    public abstract RecipeDao recipeDao();
}
