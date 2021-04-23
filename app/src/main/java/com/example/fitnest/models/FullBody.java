package com.example.fitnest.models;

import java.util.ArrayList;

public class FullBody {

    public String exerciseType;
    public int sets;
    public int reps;

    public FullBody(String exerciseType, int sets, int reps) {
        this.exerciseType = exerciseType;
        this.sets = sets;
        this.reps = reps;
    }

    public void addList() {
        FullBody dayOneExOne = new FullBody("Body squat", 3, 10);
        FullBody dayOneExTwo = new FullBody("Standing dumbbell shoulder press", 4, 10);
        FullBody dayOneExThree = new FullBody("Barbell bench press", 3, 10);
        FullBody dayOneExFour = new FullBody("Barbell curl", 3, 10);
        FullBody dayOneExFive = new FullBody("Hamstring curl", 3, 10);
        FullBody dayOneExSix = new FullBody("Sit-ups", 3, 10);

        ArrayList<FullBody> dayOneWorkout = new ArrayList<>();
        dayOneWorkout.add(dayOneExOne);
        dayOneWorkout.add(dayOneExTwo);
        dayOneWorkout.add(dayOneExThree);
        dayOneWorkout.add(dayOneExFour);
        dayOneWorkout.add(dayOneExFive);
        dayOneWorkout.add(dayOneExSix);

        FullBody dayTwoExOne = new FullBody("Split squat", 3, 10);
        FullBody dayTwoExTwo = new FullBody("Seated cable row", 3, 10);
        FullBody dayTwoExThree = new FullBody("Triceps cable pull-down", 3, 10);
        FullBody dayTwoExFour = new FullBody("Shrugs", 3, 10);
        FullBody dayTwoExFive = new FullBody("Lateral raises", 3, 10);
        FullBody dayTwoExSix = new FullBody("Dumbbell negative curls", 3, 10);

        ArrayList<FullBody> dayTwoWorkout = new ArrayList<>();
        dayTwoWorkout.add(dayTwoExOne);
        dayTwoWorkout.add(dayTwoExTwo);
        dayTwoWorkout.add(dayTwoExThree);
        dayTwoWorkout.add(dayTwoExFour);
        dayTwoWorkout.add(dayTwoExFive);
        dayTwoWorkout.add(dayTwoExSix);

        FullBody dayThreeExOne = new FullBody("Reverse Lunges", 3, 10);
        FullBody dayThreeExTwo = new FullBody("Shoulder press machine", 4, 10);
        FullBody dayThreeExThree = new FullBody("Incline bench press", 3, 10);
        FullBody dayThreeExFour = new FullBody("Bent over rows", 3, 10);
        FullBody dayThreeExFive = new FullBody("Leg extensions", 3, 10);
        FullBody dayThreeExSix = new FullBody("Dumbbell chest flies", 3, 10);

        ArrayList<FullBody> dayThreeWorkout = new ArrayList<>();
        dayThreeWorkout.add(dayThreeExOne);
        dayThreeWorkout.add(dayThreeExTwo);
        dayThreeWorkout.add(dayThreeExThree);
        dayThreeWorkout.add(dayThreeExFour);
        dayThreeWorkout.add(dayThreeExFive);
        dayThreeWorkout.add(dayThreeExSix);



    }


}
