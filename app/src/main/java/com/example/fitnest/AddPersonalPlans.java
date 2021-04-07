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
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

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

        // Configure Query
        ParseObject singleExercise = new ParseObject("SingleExercise");

        workoutName = findViewById(R.id.workoutName);
        workoutInfo = findViewById(R.id.workoutInfo);
        workoutETC = findViewById(R.id.workoutETC);
        doneButton = findViewById(R.id.doneButtonAddPersonalExercise);
        cancelbutton = findViewById(R.id.cancelButtonAddPersonalExercise);

        workoutName.setText("");
        workoutInfo.setText("");
        workoutETC.setText("");

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!workoutName.getText().toString().equals("") && !workoutInfo.getText().toString().equals("") && !workoutETC.getText().toString().equals("")){

                    singleExercise.add("exerciseName", workoutName.getText().toString());
                    singleExercise.add("workoutInfo", workoutInfo.getText().toString());
                    singleExercise.add("etc", workoutETC.getText().toString());

                    // Saving object
                    singleExercise.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                // Success
                                //sends back to personal exercise page
                                startActivity(intent);
                            } else {
                                // Error
                                Toast.makeText(AddPersonalPlans.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
                }
                else{
                    Toast.makeText(AddPersonalPlans.this, "Missing information!", Toast.LENGTH_SHORT).show();
                }
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