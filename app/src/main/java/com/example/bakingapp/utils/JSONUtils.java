package com.example.bakingapp.utils;

import android.util.Log;

import com.example.bakingapp.model.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JSONUtils {
    private final static String LOG = JSONUtils.class.getSimpleName();

    public static List<Recipe> getRecipeListFromJSON(String json) throws JSONException, ParseException {

        List<Recipe> recipeList = new ArrayList<>();

        JSONArray responseJSON = new JSONArray(json);

        for(int i=0;i < responseJSON.length(); i++) {
            JSONObject object = responseJSON.getJSONObject(i);

            int id = object.getInt("id");
            String name = object.getString("name");
            String image = object.getString("image");
            int servings = object.getInt("servings");

            Recipe recipe = new Recipe(id, image, name, servings);
            recipeList.add(recipe);

            JSONArray ingredients = object.getJSONArray("ingredients");
            JSONArray steps = object.getJSONArray("steps");
            Log.d(LOG, ""+id);
        }

        return recipeList;
    }
}
