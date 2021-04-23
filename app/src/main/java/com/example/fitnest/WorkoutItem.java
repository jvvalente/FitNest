package com.example.fitnest;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerView;
import com.parse.ParseClassName;

@ParseClassName("WorkoutItem")
public class WorkoutItem {
    
    public String workoutType, workoutInfo, videoID;
    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public WorkoutItem(){
        this.workoutType = "unknown";
        this.workoutInfo = "unknown";
        this.videoID = "unknown";
    }

    public WorkoutItem(String workoutType, String workoutInfo, String videoID) {
        this.workoutType = workoutType;
        this.workoutInfo = workoutInfo;
        this.videoID = videoID;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public String getWorkoutInfo() {
        return workoutInfo;
    }

    public void setWorkoutInfo(String workoutInfo) {
        this.workoutInfo = workoutInfo;
    }

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }
}
