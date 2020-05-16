package com.example.bakingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingapp.model.Recipe;

public class RecipeListFragment extends Fragment {
    private RecyclerView mRecipeListRecyclerView;
    private RecipeAdapter mRecipeAdapter;

    public RecipeListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe_list, container, false);

        mRecipeListRecyclerView = rootView.findViewById(R.id.rv_recipe_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecipeListRecyclerView.setLayoutManager(linearLayoutManager);
        mRecipeListRecyclerView.setHasFixedSize(true);

        mRecipeAdapter = new RecipeAdapter();
        mRecipeListRecyclerView.setAdapter(mRecipeAdapter);
        return rootView;
    }

    private void setRecipeList() {
        // TODO: create function to populate adapter with list of recipe
    }
}
