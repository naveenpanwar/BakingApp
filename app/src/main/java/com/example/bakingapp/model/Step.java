package com.example.bakingapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "step")
public class Step {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    int id;

    @ColumnInfo(name = "step_id")
    int stepId;

    @ColumnInfo(name = "short_description")
    String shortDescription;

    String description;

    @ColumnInfo(name = "video_url")
    String videoURL;

    @ColumnInfo(name = "thumbnail_url")
    String thumbnailURL;

    @ColumnInfo(name = "recipe_id")
    long recipeId;
}
