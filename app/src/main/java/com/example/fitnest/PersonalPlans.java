package com.example.fitnest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class PersonalPlans extends AppCompatActivity {

    private Button addExerciseButton;
    private Button doneButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_plans);

        addExerciseButton = findViewById(R.id.addPersonalExerciseButton);
        doneButton = findViewById(R.id.doneButtonPersonalExercise);
        cancelButton = findViewById(R.id.cancelButtonPersonalExercise);

        //Creates intent to send to add exercise activity
        Intent intent = new Intent(this, AddPersonalPlans.class);

        addExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //sends user to the add exercise activity
                startActivity(intent);

            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}