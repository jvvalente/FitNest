package com.example.fitnest;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerView;

public class WorkoutItem {

    //Workout Item functions
    YouTubePlayerView youTubePlayerView;
    private String workoutType;
    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public WorkoutItem(String workoutType) {
        this.workoutType = workoutType;
        this.expanded = false;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public YouTubePlayerView getYouTubePlayerView() {
        return youTubePlayerView;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public void setNumberPicker(){

    }
}
