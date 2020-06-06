package com.example.bakingapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bakingapp.model.Step;

import java.util.List;

@Dao
public interface StepDao {
    @Insert
    long insertStep(Step step);

    @Insert
    long[] insertSteps(Step... steps);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateStep(Step step);

    @Delete
    void deleteStep(Step step);

    @Query("SELECT * FROM step WHERE recipe_step_id = :recipe_id ORDER BY step_number DESC")
    LiveData<List<Step>> getStepsByRecipe(long recipe_id);
}
