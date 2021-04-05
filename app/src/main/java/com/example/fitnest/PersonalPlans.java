package com.example.fitnest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.example.fitnest.adapters.PersonalPlansAdapter;

import java.util.ArrayList;
import java.util.List;

public class PersonalPlans extends AppCompatActivity {

    PersonalPlansAdapter adapter;

    private Button addExerciseButton;
    private Button doneButton;
    private Button cancelButton;

    RecyclerView rvpersonal;

    Context context;

    //List workoutNames;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_plans);

        addExerciseButton = findViewById(R.id.addPersonalExerciseButton);
        doneButton = findViewById(R.id.doneButtonPersonalExercise);
        cancelButton = findViewById(R.id.cancelButtonPersonalExercise);

        ArrayList<String> workoutNames = new ArrayList<>();
        workoutNames.add("Push Up");
        workoutNames.add("Bench press");
        workoutNames.add("Squats");
        workoutNames.add("Plank");
        workoutNames.add("Burpees");
        workoutNames.add("Dumbbell rows");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvPersonalPlans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PersonalPlansAdapter(this, workoutNames);
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);



        addExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddExerciseActivity();
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBack();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBack();
            }
        });

    }

    public void openAddExerciseActivity(){
        Intent intent = new Intent(this, AddPersonalPlans.class);
        startActivity(intent);
    }

    public void sendBack(){
        Intent intent = new Intent(this, WorkoutActivity2.class);
        startActivity(intent);
    }
}