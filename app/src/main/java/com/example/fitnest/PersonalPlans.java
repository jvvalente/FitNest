package com.example.fitnest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.fitnest.adapters.PersonalPlansAdapter;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonalPlans extends AppCompatActivity {

    PersonalPlansAdapter adapter;

    private Button addExerciseButton;
    private Button doneButton;
    private Button cancelButton;

    RecyclerView rvpersonal;

    Context context;

    //List workoutNames;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_plans);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("SingleExercise");
        query.selectKeys(Arrays.asList("exerciseName"));
        query.addDescendingOrder("exerciseName");

        try {
            System.out.println("limit " + query.count());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        addExerciseButton = findViewById(R.id.addPersonalExerciseButton);
        doneButton = findViewById(R.id.doneButtonPersonalExercise);
        cancelButton = findViewById(R.id.cancelButtonPersonalExercise);

        ArrayList<String> workoutNames = new ArrayList<>();
        /*workoutNames.add("Push Up");
        workoutNames.add("Bench press");
        workoutNames.add("Squats");
        workoutNames.add("Plank");
        workoutNames.add("Burpees");
        workoutNames.add("Dumbbell rows");*/

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {

                    for (ParseObject o: objects) {
                        System.out.println("ParseObject: " + o.get("exerciseName"));
                        workoutNames.add(o.get("exerciseName").toString());
                    }

                    for (String s:workoutNames) {
                        System.out.println(s);
                    }

                    setUpAdapter(workoutNames);

                    Toast.makeText(PersonalPlans.this, "Success", Toast.LENGTH_SHORT).show();
                } else {
                    // Something is wrong
                    Toast.makeText(PersonalPlans.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        for (String s:workoutNames) {
            System.out.println(s);
        }
        // set up the RecyclerView
        /*RecyclerView recyclerView = findViewById(R.id.rvPersonalPlans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PersonalPlansAdapter(this, workoutNames);
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);*/



        addExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddExerciseActivity();
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBack();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBack();
            }
        });

    }

    public void setUpAdapter(ArrayList<String> workoutNames){
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvPersonalPlans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PersonalPlansAdapter(this, workoutNames);
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    public void openAddExerciseActivity(){
        Intent intent = new Intent(this, AddPersonalPlans.class);
        startActivity(intent);
    }

    public void sendBack(){
        Intent intent = new Intent(this, WorkoutActivity2.class);
        startActivity(intent);
    }
}