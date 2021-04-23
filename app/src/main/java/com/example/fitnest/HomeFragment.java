package com.example.fitnest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnest.adapters.HomeExerciseAdapter;
import com.example.fitnest.adapters.PersonalPlansAdapter;
import com.example.fitnest.models.SingleExercise;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    private int progress = 0;
    private ProgressBar progress_bar;
    private ProgressBar calorie_progress_bar;
    private Button button_incr;
    private Button button_decr;
    private Button testButton;
    private RecyclerView rvHome;

    HomeExerciseAdapter adapter;

    ArrayList<SingleExercise> groupNames;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {



        progress_bar = view.findViewById(R.id.progress_bar);
        calorie_progress_bar = view.findViewById(R.id.calorie_progress_bar);
        button_incr = view.findViewById(R.id.button_incr);
        button_decr = view.findViewById(R.id.button_decr);
        //TextView date = view.findViewById(R.id.date_textview);
        rvHome = view.findViewById(R.id.recyclerHome);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        //date.setText(currentDate);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Back");
        //query.selectKeys(Arrays.asList("exerciseName", "workoutReps", "workoutSets", "workoutYtID"));
        query.selectKeys(Arrays.asList("exerciseName"));
        query.addDescendingOrder("exerciseName");

        groupNames = new ArrayList<>();
        //final SingleExercise[] tempExercise = new SingleExercise[1];

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {

                    for (ParseObject o: objects) {
                        System.out.println("ParseObject: " + o.get("exerciseName"));
                        //SingleExercise tempExercise = new SingleExercise(o.get("exerciseName").toString(), Integer.parseInt(o.get("workoutReps").toString()), Integer.parseInt(o.get("workoutSets").toString()), o.get("workoutYtID").toString());
                        //groupNames.add(o.get("nameOfGroup").toString());
                        SingleExercise tempExercise = new SingleExercise(o.get("exerciseName").toString());
                        groupNames.add(tempExercise);
                    }

                    setUpAdapter(groupNames);

                    Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                } else {
                    // Something is wrong
                    Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });



        updateProgressBar();
        button_incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (progress <= 90) {
                    progress += 10;
                    updateProgressBar();
                }
            }
        });
        button_decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (progress >= 10) {
                    progress -= 10;
                    updateProgressBar();
                }
            }
        });

        /*testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });*/
    }

    private void updateProgressBar() {

        //TODO: Set water increase/decrease with default in settings
        //TODO: Connect calorie tracker with circular progress bar
        System.out.println("Progress: " + progress_bar.getProgress());
        //Handler is necessary to update progress bars
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                calorie_progress_bar.setProgress(progress);
                progress_bar.setProgress(progress);
            }
        },50);

    }

    public void setUpAdapter(ArrayList<SingleExercise> groupNames){
        // set up the RecyclerView
        RecyclerView recyclerView = getView().findViewById(R.id.recyclerHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HomeExerciseAdapter(getContext(), groupNames);
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
}