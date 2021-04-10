package com.example.fitnest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WorkoutActivity2 extends AppCompatActivity {

    FloatingActionButton nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout2);

        nextButton = findViewById(R.id.floatingActionButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPersonalPlans();
            }
        });
    }

    public void openPersonalPlans(){
        Intent intent = new Intent(this, PersonalPlans.class);
        startActivity(intent);
    }
}