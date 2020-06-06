package com.example.bakingapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "measure", indices = {@Index(value = {"name"}, unique = true)})
public class Measure {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    private String name;

    public Measure(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
