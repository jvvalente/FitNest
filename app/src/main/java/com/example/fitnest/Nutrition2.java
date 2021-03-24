package com.example.fitnest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Nutrition2 extends AppCompatActivity {

    String Meal;
    int calories, protein, carbs, fat;
    EditText MealName;
    EditText CaloriesNumber;
    EditText ProteinNumber;
    EditText CarbsNumber;
    EditText FatNumber;

   Button submitbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition2);

        MealName = (EditText) findViewById(R.id.MealName);
        CaloriesNumber = (EditText) findViewById(R.id.CaloriesNumber);
        ProteinNumber = (EditText) findViewById(R.id.ProteinNumber);
        CarbsNumber = (EditText) findViewById(R.id.CarbsNumber);
        FatNumber = (EditText) findViewById(R.id.FatNumber);

        submitbutton = (Button) findViewById(R.id.submitbutton);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Meal = MealName.getText().toString();
                calories = Integer.valueOf(CaloriesNumber.getText().toString());
                protein = Integer.valueOf(ProteinNumber.getText().toString());
                carbs = Integer.valueOf(CarbsNumber.getText().toString());
                fat = Integer.valueOf(FatNumber.getText().toString());
            }
        });


    }
}