package com.example.bakingapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ingredient")
public class Ingredient {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ingredient_id")
    private int id;

    private double quantity;

    @ColumnInfo(name = "measure_id")
    private long measureId;

    @ColumnInfo(name = "material_id")
    private long materialId;

    public Ingredient(double quantity, long measureId, long materialId) {
        this.quantity = quantity;
        this.measureId = measureId;
        this.materialId = materialId;
    }

    public int getId() {
        return id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
