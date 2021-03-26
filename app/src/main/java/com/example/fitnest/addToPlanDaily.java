package com.example.fitnest;

import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnest.adapters.AddDailyAdapter;
import com.example.fitnest.adapters.WorkoutAdapter;

import java.util.ArrayList;

import devs.mulham.horizontalcalendar.HorizontalCalendar;

public class addToPlanDaily extends Fragment {

    private EditText setNum;
    private EditText repNum;
    private EditText weightNum;
    private Button doneButton;
    private Button cancelbutton;
    
    RecyclerView rvdaily;

    private ArrayList<DailyPlanItem> exerciseList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_personal_plans);
//
//        //Creates intent for going back to personal exercise page
//        Intent intent = new Intent(this, PersonalPlans.class);
//
//        setNum = findViewById(R.id.setNum);
//        repNum = findViewById(R.id.repNum);
//        weightNum = findViewById(R.id.weight);
//        doneButton = findViewById(R.id.doneButtonAddPersonalExercise);
//        cancelbutton = findViewById(R.id.cancelButtonAddPersonalExercise);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sends back to personal exercise page
//                startActivity(intent);
            }
        });

        cancelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sends back to personal exercise page
//                startActivity(intent);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_workout, container, false);

        exerciseList = new ArrayList<>();
        setexerciseList();

        //sets up the RecyclerView and it's adapter
        v = setRecyclerView(v);

        return v;
    }

    //temporaty function to hardcode some values
    //TODO: get the data from our database
    private void setexerciseList(){
        exerciseList.add(new DailyPlanItem("Push Up"));
        exerciseList.add(new DailyPlanItem("Tricep Pull Down"));
        exerciseList.add(new DailyPlanItem("Bench Press"));
    }

    private View setRecyclerView(View v){
        //Get reference to recycler view
        rvdaily = (RecyclerView) v.findViewById(R.id.rvDaily);
        //set layout manager
        rvdaily.setLayoutManager(new LinearLayoutManager(getActivity()));
        //create an adapter
        AddDailyAdapter dailyAdapter = new AddDailyAdapter(exerciseList);
        //set the adapter
        rvdaily.setAdapter(dailyAdapter);
        //set item animator to Default animator
        rvdaily.setItemAnimator(new DefaultItemAnimator());

        return v;
    }
}