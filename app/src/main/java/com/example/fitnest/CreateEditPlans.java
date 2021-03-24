package com.example.fitnest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CreateEditPlans extends AppCompatActivity {
    private Button activityPersonalPlans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_workoutpage2);

        activityPersonalPlans = findViewById(R.id.floatingActionButton);
        activityPersonalPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActPerPlan();
            }
        });
    }
    public void openActPerPlan() {
        Intent intent = new Intent(this, PersonalPlans.class);
        startActivity(intent);
    }
}
