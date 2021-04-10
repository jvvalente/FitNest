package com.example.fitnest;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    EditText settingsName;
    EditText settingsHeight;
    EditText settingsWeight;
    EditText settingsLevel;
    EditText settingsPlan;
    Switch settingsNotify;
    EditText settingsIntake;
    EditText settingsGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("SettingsActivity","Settings activity onCreate method");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settingsName = findViewById(R.id.settingsName);
        settingsHeight = findViewById(R.id.settingsHeight);
        settingsWeight = findViewById(R.id.settingsWeight);
        settingsLevel = findViewById(R.id.settingsLevel);
        settingsPlan = findViewById(R.id.settingsPlan);
        settingsNotify = findViewById(R.id.settingsNotify);
        settingsIntake = findViewById(R.id.settingsIntake);
        settingsGoal = findViewById(R.id.settingsGoal);

    }
}
