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
import android.widget.ListView;

import com.example.fitnest.adapters.GoalsToAccomplishAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgressFragment extends Fragment {

    RecyclerView rvGoalsTo;
    private ArrayList<ToAccomplishItem> goalsList;

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
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_progress, container, false);
        setHasOptionsMenu(true);

        goalsList = new ArrayList<>();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("GoalsToAccomplish");
        query.selectKeys(Arrays.asList("Goal"));
        query.addAscendingOrder("Goal");
        goalsList.add(new ToAccomplishItem("GoalThree"));

            query.findInBackground(new FindCallback<ParseObject>() {

                @Override
                public void done(List<ParseObject> objects, ParseException e) {
                    if (e == null) {

                        goalsList.add(new ToAccomplishItem("GoalTwo"));

                        for (ParseObject o : objects) {
                            System.out.println("ParseObject: " + o.get("Goal"));
                        goalsList.add(new ToAccomplishItem(o.get("Goal").toString()));
//                            goalsList.add(new ToAccomplishItem("GoalOne"));
                        }

                    } else {
                        // Something is wrong}
//                        goalsList.add(new ToAccomplishItem("GoalFour"));
                    }
                }
            });

//        setGoalsList();

        goalsList.add(new ToAccomplishItem("GoalFinal"));

        v = setRecyclerView(v);

        return v;
    }

    private View setRecyclerView(View v){
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

}