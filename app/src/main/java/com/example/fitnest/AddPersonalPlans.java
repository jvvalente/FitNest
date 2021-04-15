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
    private EditText workoutSets;
    private EditText workoutReps;
    private EditText workoutYtID;
    private Button doneButton;
    private Button cancelbutton;

    String tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_personal_plans);

        Bundle bundle = getIntent().getExtras();
        tableName = bundle.getString("tableName");

        // Configure Query
        ParseObject singleExercise = new ParseObject(tableName);

        workoutName = findViewById(R.id.workoutName);
        workoutSets = findViewById(R.id.workoutSets);
        workoutReps = findViewById(R.id.workoutReps);
        workoutYtID = findViewById(R.id.workoutYtId);
        doneButton = findViewById(R.id.doneButtonAddPersonalExercise);
        cancelbutton = findViewById(R.id.cancelButtonAddPersonalExercise);

        workoutName.setText("");
        workoutSets.setText("");
        workoutReps.setText("");
        workoutYtID.setText("");

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!workoutName.getText().toString().equals("") && !workoutSets.getText().toString().equals("") && !workoutReps.getText().toString().equals("") && !workoutYtID.getText().toString().equals("")){

                    singleExercise.add("exerciseName", workoutName.getText().toString());
                    singleExercise.add("workoutSets", workoutSets.getText().toString());
                    singleExercise.add("workoutReps", workoutReps.getText().toString());
                    singleExercise.add("workoutYtID", workoutYtID.getText().toString());

                    // Saving object
                    singleExercise.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                // Success
                                //sends back to personal exercise page
                                sendBack();
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
                sendBack();
            }
        });

    }

    private void sendBack(){
        //Creates intent for going back to personal exercise page
        Intent intent = new Intent(this, PersonalPlans.class);
        intent.putExtra("WorkoutGroupName", tableName);
        startActivity(intent);
    }









}