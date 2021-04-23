package com.example.fitnest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.fitnest.adapters.PersonalPlansAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkoutActivity2 extends AppCompatActivity implements PersonalPlansAdapter.ItemClickListener{

    FloatingActionButton nextButton;

    EditText newWorkoutGroup;

    PersonalPlansAdapter adapter;

    ArrayList<String> groupNames;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout2);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("GroupTable");
        query.selectKeys(Arrays.asList("nameOfGroup"));
        query.addDescendingOrder("nameOfGroup");

        groupNames = new ArrayList<>();

        context = getBaseContext();

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {

                    for (ParseObject o: objects) {
                        System.out.println("ParseObject: " + o.get("nameOfGroup"));
                        groupNames.add(o.get("nameOfGroup").toString());
                    }

                    setUpAdapter(groupNames);

                    Toast.makeText(WorkoutActivity2.this, "Success", Toast.LENGTH_SHORT).show();
                } else {
                    // Something is wrong
                    Toast.makeText(WorkoutActivity2.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        nextButton = findViewById(R.id.floatingActionButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflateDialog();
            }
        });
    }



    private void inflateDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view = this.getLayoutInflater().inflate(R.layout.workout_popup, null);
        builder.setView(view);

        //EditText newWorkoutGroup = findViewById(R.id.editTextWorkoutGroup);

        //newWorkoutGroup.setText("");

        builder.setMessage("Please enter new workout group name");

        // Set an EditText view to get user input
        final EditText input = new EditText(this);
        builder.setView(input);

        input.setText("");

        builder.setMessage("Please enter new workout group name")
                .setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if(!input.getText().toString().equals("")){
                            String workoutGroupName = input.getText().toString();
                            addToTable(workoutGroupName);
                            openPersonalPlans(workoutGroupName);
                        }
                    }
                });

        builder.setNegativeButton("Cancel", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // allows plans to be accessed and opened to allow user to use workout during the current day
    private void openPersonalPlans(String name){
        Intent intent = new Intent(this, PersonalPlans.class);
        intent.putExtra("WorkoutGroupName", name);
        startActivity(intent);
    }

    private void addToTable(String name){

        // Configure Query
        ParseObject groupTable = new ParseObject("GroupTable");

        groupTable.add("nameOfGroup", name);

        // Saving object
        groupTable.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    // Success

                } else {
                    // Error
                    Toast.makeText(WorkoutActivity2.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    public void setUpAdapter(ArrayList<String> groupNames){
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvPersonalPlans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PersonalPlansAdapter(this, groupNames);
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        System.out.println("It get's here");
        openPersonalPlans(groupNames.get(position));
    }
}