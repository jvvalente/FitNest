package com.example.fitnest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPersonalPlans extends AppCompatActivity {

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