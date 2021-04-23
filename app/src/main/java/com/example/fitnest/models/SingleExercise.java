package com.example.fitnest.models;

public class SingleExercise {

    String exerciseName;
    int exerciseReps;
    int exeeciseSets;
    String ytID;

    public SingleExercise(String exerciseName){
        this.exerciseName = exerciseName;
    }

    public SingleExercise(String exerciseName, int exerciseReps, int exeeciseSets, String ytID) {
        this.exerciseName = exerciseName;
        this.exerciseReps = exerciseReps;
        this.exeeciseSets = exeeciseSets;
        this.ytID = ytID;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getExerciseReps() {
        return exerciseReps;
    }

    public void setExerciseReps(int exerciseReps) {
        this.exerciseReps = exerciseReps;
    }

    public int getExeeciseSets() {
        return exeeciseSets;
    }

    public void setExeeciseSets(int exeeciseSets) {
        this.exeeciseSets = exeeciseSets;
    }

    public String getYtID() {
        return ytID;
    }

    public void setYtID(String ytID) {
        this.ytID = ytID;
    }
}
