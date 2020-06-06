package com.example.bakingapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import com.example.bakingapp.model.Step;

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
}
