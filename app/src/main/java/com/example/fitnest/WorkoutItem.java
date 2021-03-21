package com.example.fitnest;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerView;

public class WorkoutItem {
    YouTubePlayerView youTubePlayerView;

    private String workoutType;

    public WorkoutItem(String workoutType) {
        this.workoutType = workoutType;
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

}
