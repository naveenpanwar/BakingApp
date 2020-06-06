package com.example.bakingapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.bakingapp.model.Material;
import com.example.bakingapp.model.RecipeWithIngredients;

import java.util.List;

@Dao
public interface MaterialDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertMaterial(Material material);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateMaterial(Material material);

    @Delete
    void deleteMaterial(Material material);
}
