package com.example.bakingapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import com.example.bakingapp.model.Material;
import com.example.bakingapp.model.Measure;

@Dao
public interface MeasureDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertMeasure(Measure measure);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateMeasure(Measure measure);

    @Delete
    void deleteMeasure(Measure measure);
}
