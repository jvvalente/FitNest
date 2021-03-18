package com.example.fitnest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class addToPlanDaily extends AppCompatActivity {

    private EditText setNum;
    private EditText repNum;
    private EditText weightNum;
    private Button doneButton;
    private Button cancelbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_personal_plans);

        //Creates intent for going back to personal exercise page
        Intent intent = new Intent(this, PersonalPlans.class);

        setNum = findViewById(R.id.setNum);
        repNum = findViewById(R.id.repNum);
        weightNum = findViewById(R.id.weight);
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