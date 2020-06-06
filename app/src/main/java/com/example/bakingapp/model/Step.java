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
    @ColumnInfo(name = "step_id")
    int stepId;

    @ColumnInfo(name = "step_number")
    int stepNumber;

    @ColumnInfo(name = "short_description")
    String shortDescription;

    String description;

    @ColumnInfo(name = "video_url")
    String videoURL;

    @ColumnInfo(name = "thumbnail_url")
    String thumbnailURL;

    @ColumnInfo(name = "recipe_step_id")
    long recipeStepId;

    public Step(int stepNumber, String shortDescription, String description, String videoURL,
                String thumbnailURL, long recipeStepId) {
        this.stepNumber = stepNumber;
        this.shortDescription = shortDescription;
        this.description = description;
        this.videoURL = videoURL;
        this.thumbnailURL = thumbnailURL;
        this.recipeStepId = recipeStepId;
    }

    public int getStepId() {
        return stepId;
    }

    public void setStepId(int id) {
        this.stepId = id;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public long getRecipeStepId() {
        return recipeStepId;
    }

    public void setRecipeStepId(long recipeStepId) {
        this.recipeStepId = recipeStepId;
    }
}
