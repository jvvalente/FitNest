package com.example.fitnest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitnest.adapters.PersonalPlansAdapter;
import com.example.fitnest.adapters.WorkoutAdapter;

import java.util.ArrayList;

public class AddPersonalPlans extends AppCompatActivity  {

    PersonalPlansAdapter adapter;

    private EditText workoutName;
    private EditText workoutInfo;
    private EditText workoutETC;
    private Button doneButton;
    private Button cancelbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_personal_plans);

        //Creates intent for going back to personal exercise page
        Intent intent = new Intent(this, PersonalPlans.class);

        workoutName = findViewById(R.id.workoutName);
        workoutInfo = findViewById(R.id.workoutInfo);
        workoutETC = findViewById(R.id.workoutETC);
        doneButton = findViewById(R.id.doneButtonAddPersonalExercise);
        cancelbutton = findViewById(R.id.cancelButtonAddPersonalExercise);




        // set up the RecyclerView
        /*RecyclerView recyclerView = findViewById(R.id.rvPersonalPlans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PersonalPlansAdapter(this, workoutNames);
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);*/

       

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sends back to personal exercise page
                startActivity(intent);
            }
        });

        cancelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sends back to personal exercise page
                startActivity(intent);
            }
        });

    }









}