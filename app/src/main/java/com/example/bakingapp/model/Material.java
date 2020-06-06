package com.example.bakingapp.model;

import androidx.annotation.ColorLong;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "material", indices = {@Index(value = {"name"}, unique = true)})
public class Material {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "material_id")
    private int materialId;

    private String name;

    public Material(String name) {
        this.name = name;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
