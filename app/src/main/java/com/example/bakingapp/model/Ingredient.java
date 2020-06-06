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
    private int ingredientId;

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

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public long getMeasureId() {
        return measureId;
    }

    public void setMeasureId(long measureId) {
        this.measureId = measureId;
    }

    public long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(long materialId) {
        this.materialId = materialId;
    }
}
