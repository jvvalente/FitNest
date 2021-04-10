package com.example.fitnest.models;

public class SingleExercise {

    String exerciseName;
    String workoutInfo;
    String etc;

    public SingleExercise(String exerciseName, String workoutInfo, String ETC) {
        this.exerciseName = exerciseName;
        this.workoutInfo = workoutInfo;
        this.etc = ETC;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getWorkoutInfo() {
        return workoutInfo;
    }

    public void setWorkoutInfo(String workoutInfo) {
        this.workoutInfo = workoutInfo;
    }

    public String getETC() {
        return etc;
    }

    public void setETC(String ETC) {
        this.etc = ETC;
    }

}
