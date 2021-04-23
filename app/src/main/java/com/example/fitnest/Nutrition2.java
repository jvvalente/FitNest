package com.example.fitnest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class Nutrition2 extends AppCompatActivity {


    public static String Meal;
    public static int calories, protein, carbs, fat;

    EditText MealName;
    EditText CaloriesNumber;
    EditText ProteinNumber;
    EditText CarbsNumber;
    EditText FatNumber;
    ParseObject MealObject = new ParseObject("Nutrition");
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
        MealObject = ParseUser.getCurrentUser();
        submitbutton = (Button) findViewById(R.id.submitbutton);
        submitbutton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                Meal = MealName.getText().toString();
                calories = Integer.valueOf(CaloriesNumber.getText().toString());
                protein = Integer.valueOf(ProteinNumber.getText().toString());
                carbs = Integer.valueOf(CarbsNumber.getText().toString());
                fat = Integer.valueOf(FatNumber.getText().toString());



                MealObject.add("MealName", Meal.toString());
                MealObject.add("Calories", Integer.valueOf(CaloriesNumber.getText().toString()));
                MealObject.add("Protein", Integer.valueOf(ProteinNumber.getText().toString()));
                MealObject.add("Carbs", Integer.valueOf(CarbsNumber.getText().toString()));
                MealObject.add("Fats", Integer.valueOf(FatNumber.getText().toString()));



                MealObject.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {

                            Toast.makeText(Nutrition2.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            // Success
                        } else {
                            // Error
                        }
                    }
                });
                    
                gohome();
            }
        });

    }

    private void gohome() {
        Intent i = new Intent(this, NutritionFragment.class);
        startActivity(i);
    }


}