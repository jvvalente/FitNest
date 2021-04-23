package com.example.fitnest;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnest.adapters.AccomplishedGoalsAdapter;
import com.example.fitnest.adapters.GoalsToAccomplishAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgressFragment extends Fragment {

    RecyclerView rvGoalsTo;
    RecyclerView rvGoals;
    private int pointCount;
    private ArrayList<ToAccomplishItem> goalsList;
    private ArrayList<AccomplishedItem> goalsListDone;

    EditText addGoal;
    Button addGoalButton;

    public ProgressFragment() {
        // Required empty public constructor
    }

    public static ProgressFragment newInstance(String param1, String param2) {
        ProgressFragment fragment = new ProgressFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_progress, container, false);
        setHasOptionsMenu(true);

        addGoal = v.findViewById(R.id.editTextAddGoal);
        addGoalButton = v.findViewById(R.id.buttonAddGoal);

        ParseQuery<ParseObject> count = ParseQuery.getQuery("AccomplishedGoals");
        count.selectKeys(Arrays.asList("Points"));
        count.addAscendingOrder("Points");
        count.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {

                    for (ParseObject o : objects) {
                        System.out.println("ParseObject: " + o.get("Points"));
//                        goalsListDone.add(new AccomplishedItem(o.get("Goal").toString()));
                        pointCount += 10;
                    }
                    String pointsT = String.valueOf(pointCount);
                    setPointCounter(v, pointsT);

                } else {
                    // Something is wrong}
                }
            }
        });

        goalsList = new ArrayList<>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("GoalsToAccomplish");
        query.selectKeys(Arrays.asList("Goal"));
        query.addAscendingOrder("Goal");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {

                    for (ParseObject o : objects) {
                        System.out.println("ParseObject: " + o.get("Goal"));
                        goalsList.add(new ToAccomplishItem(o.get("Goal").toString()));
                    }
                    setRecyclerView1(v);

                } else {
                    // Something is wrong}
                }
            }
        });

        goalsListDone = new ArrayList<>();
        ParseQuery<ParseObject> queryDone = ParseQuery.getQuery("AccomplishedGoals");
        queryDone.selectKeys(Arrays.asList("Goal"));
        queryDone.addAscendingOrder("Goal");
        queryDone.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {

                    for (ParseObject o : objects) {
                        System.out.println("ParseObject: " + o.get("Goal"));
                        goalsListDone.add(new AccomplishedItem(o.get("Goal").toString()));
                    }
                    setRecyclerView2(v);

                } else {
                    // Something is wrong}
                }
            }
        });

        addGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject addGoal1 = new ParseObject("GoalsToAccomplish");
                String goal = addGoal.getText().toString();

                addGoal1.put("Goal", goal);

                addGoal1.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            // Success
                            //sends back to personal exercise page

                        } else {
                            // Error
                            System.out.println("error");
                        }
                    }
                });
            }
        });

        return v;
    }

    private void setPointCounter(View v, String pointsNew){
//        pointCount = v.findViewById(R.id.statusImage);
        TextView points = (TextView) v.findViewById(R.id.statusImage);
        points.setText(pointsNew);

    }

    private View setRecyclerView1(View v){
        //Get reference to recycler view
        rvGoalsTo = (RecyclerView) v.findViewById(R.id.rvToAccomplish);
        //set layout manager
        rvGoalsTo.setLayoutManager(new LinearLayoutManager(getActivity()));
        //create an adapter
        GoalsToAccomplishAdapter goalsAdapter = new GoalsToAccomplishAdapter(getActivity(), goalsList);
        //set the adapter
        rvGoalsTo.setAdapter(goalsAdapter);
        //set item animator to Default animator
        rvGoalsTo.setItemAnimator(new DefaultItemAnimator());

        return v;
    }

    private View setRecyclerView2(View v){
        //Get reference to recycler view
        rvGoals = (RecyclerView) v.findViewById(R.id.rvAccomplished);
        //set layout manager
        rvGoals.setLayoutManager(new LinearLayoutManager(getActivity()));
        //create an adapter
        AccomplishedGoalsAdapter goalsAdapter = new AccomplishedGoalsAdapter(getActivity(), goalsListDone);
        //set the adapter
        rvGoals.setAdapter(goalsAdapter);
        //set item animator to Default animator
        rvGoals.setItemAnimator(new DefaultItemAnimator());

        return v;
    }

}