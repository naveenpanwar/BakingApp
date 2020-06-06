package com.example.bakingapp.utils;

import android.content.Context;
import android.util.Log;

import com.example.bakingapp.database.RecipeDatabase;
import com.example.bakingapp.model.Ingredient;
import com.example.bakingapp.model.Material;
import com.example.bakingapp.model.Measure;
import com.example.bakingapp.model.Recipe;
import com.example.bakingapp.model.RecipeIngredientCrossRef;
import com.example.bakingapp.model.Step;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JSONUtils {
    private final static String LOG = JSONUtils.class.getSimpleName();

    public static List<Recipe> populateRecipeDBFromJSON(String json, Context context) throws JSONException, ParseException {
        RecipeDatabase db = RecipeDatabase.getInstance(context);
        List<Recipe> recipeList = new ArrayList<>();

        JSONArray responseJSON = new JSONArray(json);

        for(int i=0; i<responseJSON.length(); i++) {
            JSONObject object = responseJSON.getJSONObject(i);

            int id = object.getInt("id");
            String name = object.getString("name");
            String image = object.getString("image");
            int servings = object.getInt("servings");

            Recipe recipe = new Recipe(id, image, name, servings);
            long recipe_id = db.recipeDao().insertRecipe(recipe);
            Log.d(LOG,"Recipe ID"+recipe_id);
            recipeList.add(recipe);

            JSONArray ingredients = object.getJSONArray("ingredients");
            for( int j=0; j < ingredients.length(); j++) {
                JSONObject ingredient = ingredients.getJSONObject(j);
                double quantity = ingredient.getDouble("quantity");
                String measure = ingredient.getString("measure");
                String material = ingredient.getString("ingredient");

                Measure measure_obj = new Measure(measure);
                Material material_obj = new Material(material);
                long measure_id = db.measureDao().insertMeasure(measure_obj);
                Log.d(LOG,"Measure ID"+measure_id);
                long material_id = db.materialDao().insertMaterial(material_obj);
                Log.d(LOG,"Material ID"+material_id);

                Ingredient ingredient_obj = new Ingredient(quantity, measure_id, material_id);
                long ingredient_id = db.ingredientDao().insertIngredient(ingredient_obj);
                Log.d(LOG,"Ingredient ID"+ingredient_id);

                // Insert a row in reference table
                RecipeIngredientCrossRef ref = new RecipeIngredientCrossRef(recipe_id, ingredient_id);
                db.recipeIngredientCrossRefDao().insertRecipeIngredientCrossRef(ref);
            }

            JSONArray steps = object.getJSONArray("steps");
            for(int k=0; k< steps.length(); k++) {
                JSONObject step = steps.getJSONObject(k);
                int stepId = step.getInt("id");
                String shortDescription = step.getString("shortDescription");
                String description = step.getString("description");
                String videoURL = step.getString("videoURL");
                String thumbnailURL = step.getString("thumbnailURL");

                Step step_obj = new Step(stepId, shortDescription, description, videoURL, thumbnailURL, recipe_id);
                long step_id = db.stepDao().insertStep(step_obj);
                Log.d(LOG,"Step ID"+step_id);
            }
        }

        return recipeList;
    }
}
