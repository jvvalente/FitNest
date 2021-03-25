package com.example.fitnest;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class AccomplishedItem {

    //Workout Item functions
    private String accomplishment;

    public AccomplishedItem(String accomplishment) {
        this.accomplishment = accomplishment;
    }

    public String getAccomplishment() {
        return accomplishment;
    }

    public void setAccomplishment(String accomplishment) {
        this.accomplishment = accomplishment;
    }
}
