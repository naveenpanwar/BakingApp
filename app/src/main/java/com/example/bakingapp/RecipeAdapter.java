package com.example.bakingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingapp.model.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapterViewHolder> {
    private List<Recipe> mRecipeList;
    @NonNull
    @Override
    public RecipeAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        boolean attachToParentImmediately = false;
        View view = LayoutInflater.from(context).inflate(
                R.layout.recipe_list_item,
                parent,
                attachToParentImmediately);
        return new RecipeAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapterViewHolder holder, int position) {
        Recipe recipe = mRecipeList.get(position);
        holder.setRecipeName(recipe.getName());
        if( recipe.getImage() != null || recipe.getImage().length() != 0 ) {
            // TODO: code to populate the image if available
        }
    }

    @Override
    public int getItemCount() {
        if( mRecipeList != null ) {
            return mRecipeList.size();
        }
        return 0;
    }
}
