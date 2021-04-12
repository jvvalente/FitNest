package com.example.fitnest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseInstallation;
import com.parse.ParseUser;

public class SettingsActivity extends AppCompatActivity {
    EditText settingsName;
    EditText settingsHeight;
    EditText settingsWeight;
    EditText settingsLevel;
    EditText settingsPlan;
    Switch settingsNotify;
    EditText settingsIntake;
    EditText settingsGoal;
    Button btnSave;
    ParseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("SettingsActivity","Settings activity onCreate method");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        settingsName = findViewById(R.id.settingsName);
        settingsHeight = findViewById(R.id.settingsHeight);
        settingsWeight = findViewById(R.id.settingsWeight);
        settingsLevel = findViewById(R.id.settingsLevel);
        settingsPlan = findViewById(R.id.settingsPlan);
        settingsNotify = findViewById(R.id.settingsNotify); //type Switch
        settingsIntake = findViewById(R.id.settingsIntake);
        settingsGoal = findViewById(R.id.settingsGoal);
        btnSave = findViewById(R.id.btnSave);

        user = ParseUser.getCurrentUser();
        Log.i("SettingsActivity", "The current user is " + user.getUsername());

        btnSave.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //when user clicks save, update the database with this information
                user.put("Name",settingsName.getText().toString());
                user.put("Height",settingsHeight.getText().toString());
                user.put("Weight",settingsWeight.getText().toString());
                user.put("Level",settingsLevel.getText().toString());
                user.put("Plan",settingsPlan.getText().toString());
                user.put("Water_Intake",settingsIntake.getText().toString());
                user.put("Goal",settingsGoal.getText().toString());

                goHome();
            }
        });
    }
    public void goHome(){
        Log.i("SettingsActivity","Name: " + user.get("Name"));
        Log.i("SettingsActivity","Height: " + user.get("Height"));
        Log.i("SettingsActivity","Weight: " + user.get("Weight"));
        Log.i("SettingsActivity","Level: " + user.get("Level"));
        Log.i("SettingsActivity","Plan: " + user.get("Plan"));
        Log.i("SettingsActivity","Water_Intake: " + user.get("Water_Intake"));
        Log.i("SettingsActivity","Goal: " + user.get("Goal"));
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
