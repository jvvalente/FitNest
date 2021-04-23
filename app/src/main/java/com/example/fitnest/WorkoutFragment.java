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
import com.parse.ParseInstallation;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class WorkoutFragment extends Fragment {
    ParseUser user;
    HorizontalCalendar horizontalCalendar;
    RecyclerView rvWorkout;

    private ArrayList<WorkoutItem> workoutList;

    private ArrayList<ArrayList<WorkoutItem>> workoutArray;

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

        user = ParseUser.getCurrentUser();

        //calendar stuff

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

        workoutArray = new ArrayList<>();
        for(int i = 0; i<100; i++){
            workoutArray.add(new ArrayList<>());
        }

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
           @Override
           public void onDateSelected(Calendar date, int position) {
               user.put("dateIndex",position);
               setWorkoutList();
               //Get reference to recycler view
               rvWorkout = (RecyclerView) v.findViewById(R.id.rvWorkout);
               //set layout manager
               rvWorkout.setLayoutManager(new LinearLayoutManager(getActivity()));
               //create an adapter
               WorkoutAdapter workoutAdapter = new WorkoutAdapter(getActivity(),workoutArray.get(position));
               //set the adapter
               rvWorkout.setAdapter(workoutAdapter);
               //set item animator to Default animator
               rvWorkout.setItemAnimator(new DefaultItemAnimator());

               String pos = "" + position;
               Toast.makeText(getContext(), pos, Toast.LENGTH_LONG).show();
           }
        });

        return v;
    }

    //temporary function to hardcode some values
    //TODO: get the data from our database
    private void setWorkoutList(){
        int index = (int)user.get("dateIndex");
        Log.i("WorkoutFragment","date index = " + index);
        workoutArray.get(35).add(new WorkoutItem("pushup","do a pushup","<iframe width=\"100%\" height=\"100%\" src=\"" + String.format("https://www.youtube.com/embed/%s","IODxDxX7oi4") + "\" frameborder=\"0\" allowfullscreen><iframe>" ));
        workoutArray.get(35).add(new WorkoutItem("sit up","Do a situp","<iframe width=\"100%\" height=\"100%\" src=\"" + String.format("https://www.youtube.com/embed/%s","1fbU_MkV7NE") + "\" frameborder=\"0\" allowfullscreen><iframe>" ));
        workoutArray.get(35).add(new WorkoutItem("weights","do dumbell curl ups","<iframe width=\"100%\" height=\"100%\" src=\"" + String.format("https://www.youtube.com/embed/%s","av7-8igSXTs") + "\" frameborder=\"0\" allowfullscreen><iframe>" ));
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