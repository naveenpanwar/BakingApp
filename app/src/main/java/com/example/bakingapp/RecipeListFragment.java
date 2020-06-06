package com.example.bakingapp;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingapp.model.Recipe;
import com.example.bakingapp.utils.JSONUtils;
import com.example.bakingapp.utils.NetworkUtils;
import com.example.bakingapp.utils.RecipeExecutors;


import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;

public class RecipeListFragment extends Fragment {
    private final static String LOG = RecipeListFragment.class.getSimpleName();

    private RecyclerView mRecipeListRecyclerView;
    private RecipeAdapter mRecipeAdapter;

    public RecipeListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_recipe_list, container,
                false);
        final Context context = getActivity();

        mRecipeListRecyclerView = rootView.findViewById(R.id.rv_recipe_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecipeListRecyclerView.setLayoutManager(linearLayoutManager);
        mRecipeListRecyclerView.setHasFixedSize(true);

        mRecipeAdapter = new RecipeAdapter();
        mRecipeListRecyclerView.setAdapter(mRecipeAdapter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            RecipeExecutors.getInstance().networkIO().execute(new Runnable() {
                @Override
                public void run() {
                    setRecipeList(context);
                }
            });
        }

        return rootView;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setRecipeList(Context context) {
        String data = null;
        try {
            data = NetworkUtils.getRecipeData();
        } catch (IOException e) {
            Log.d(LOG, "IOException");
            e.printStackTrace();
        }
        if( data != null && !data.equals("") ) {
            try {
                mRecipeAdapter.setRecipeList(JSONUtils.populateRecipeDBFromJSON(data, context));
                RecipeExecutors.getInstance().mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        mRecipeAdapter.notifyDataSetChanged();
                    }
                });
            } catch (JSONException | ParseException e) {
                e.printStackTrace();
            }
        } else {
            Log.d(LOG, "JSON is null or Empty string");
        }
    }
}
