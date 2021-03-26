package com.example.fitnest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnest.adapters.AddWeeklyAdapter;
import com.example.fitnest.adapters.WorkoutAdapter;

import java.util.ArrayList;

public class addToPlanWeekly extends Fragment {

    private EditText setNum;
    private EditText repNum;
    private EditText weightNum;
    private Button doneButton;
    private Button cancelbutton;
    
    RecyclerView rvWeekly;

    private ArrayList<WeeklyPlanItem> exerciseList;

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
        exerciseList.add(new WeeklyPlanItem("Push Up"));
        exerciseList.add(new WeeklyPlanItem("Tricep Pull Down"));
        exerciseList.add(new WeeklyPlanItem("Bench Press"));
    }

    private View setRecyclerView(View v){
        //Get reference to recycler view
        rvWeekly = (RecyclerView) v.findViewById(R.id.rvWeekly);
        //set layout manager
        rvWeekly.setLayoutManager(new LinearLayoutManager(getActivity()));
        //create an adapter
        AddWeeklyAdapter weeklyAdapter = new AddWeeklyAdapter(exerciseList);
        //set the adapter
        rvWeekly.setAdapter(weeklyAdapter);
        //set item animator to Default animator
        rvWeekly.setItemAnimator(new DefaultItemAnimator());

        return v;
    }
}