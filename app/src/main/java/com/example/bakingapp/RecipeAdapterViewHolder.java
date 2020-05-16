package com.example.bakingapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeAdapterViewHolder extends RecyclerView.ViewHolder {
    final private TextView recipeNameTextView;

    public RecipeAdapterViewHolder(@NonNull View itemView) {
        super(itemView);
        recipeNameTextView = itemView.findViewById(R.id.tv_recipe_name);
    }

    public void setRecipeName(String recipeName) {
        recipeNameTextView.setText(recipeName);
    }
}
