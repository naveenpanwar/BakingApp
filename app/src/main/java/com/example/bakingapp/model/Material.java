package com.example.bakingapp.model;

import androidx.annotation.ColorLong;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity( tableName = "material")
public class Material {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    private String name;

    public Material(String name) {
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
