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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.fitnest.adapters.WorkoutAdapter;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class WorkoutFragment extends Fragment {

    HorizontalCalendar horizontalCalendar;
    RecyclerView rvWorkout;

    private ArrayList<WorkoutItem> workoutList;

    public WorkoutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.workout_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_workout, container, false);
        setHasOptionsMenu(true);

        workoutList = new ArrayList<>();
        setWorkoutList();

        //sets up the RecyclerView and it's adapter
        v = setRecyclerView(v);

        //sets up the HorizontalCalendar
        v = setHorizontalCalendar(v);

        return v;
    }

    //temporaty function to hardcode some values
    //TODO: get the data from our database
    private void setWorkoutList(){
        workoutList.add(new WorkoutItem("pushup"));
        workoutList.add(new WorkoutItem("sit up"));
        workoutList.add(new WorkoutItem("weights"));
    }

    private View setRecyclerView(View v){
        //Get reference to recycler view
        rvWorkout = (RecyclerView) v.findViewById(R.id.rvWorkout);
        //set layout manager
        rvWorkout.setLayoutManager(new LinearLayoutManager(getActivity()));
        //create an adapter
        WorkoutAdapter workoutAdapter = new WorkoutAdapter(getActivity(),workoutList);
        //set the adapter
        rvWorkout.setAdapter(workoutAdapter);
        //set item animator to Default animator
        rvWorkout.setItemAnimator(new DefaultItemAnimator());

        return v;
    }

    private View setHorizontalCalendar(View v){
        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        horizontalCalendar = new HorizontalCalendar.Builder(v, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                //do something
            }
        });

        return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add_button:
                Intent intent = new Intent(getContext(), WorkoutActivity2.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}