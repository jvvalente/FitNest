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

import com.example.fitnest.adapters.GoalsToAccomplishAdapter;
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

public class ProgressActivity extends AppCompatActivity implements PersonalPlansAdapter.ItemClickListener{

    EditText newWorkoutGroup;

    GoalsToAccomplishAdapter adapter;

    ArrayList<String> goals;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_progress);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("User");
        query.selectKeys(Arrays.asList("Goal"));
        query.addDescendingOrder("Goal");

        goals = new ArrayList<>();

        context = getBaseContext();

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {

                    for (ParseObject o: objects) {
                        System.out.println("ParseObject: " + o.get("Goal"));
                        goals.add(o.get("Goal").toString());
                    }

                    setUpAdapter(goals);

                    Toast.makeText(ProgressActivity.this, "Success", Toast.LENGTH_SHORT).show();
                } else {
                    // Something is wrong
                    Toast.makeText(ProgressActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setUpAdapter(ArrayList<String> goals){
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvToAccomplish);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GoalsToAccomplishAdapter(this, goals);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
