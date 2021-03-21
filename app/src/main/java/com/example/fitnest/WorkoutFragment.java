package com.example.fitnest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public static final String YOUTUBE_API_KEY = "AIzaSyAIF6220mZ2d1v53FU7cvOeSh2as1kmT44";
    YouTubePlayerView youTubePlayerView;

    HorizontalCalendar horizontalCalendar;
    RecyclerView rvWorkout;

    private ArrayList<WorkoutItem> workoutList;

    public WorkoutFragment() {
        // Required empty public constructor
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

        //Try to get the recylcerview to work without the youtube video
        //youTubePlayerView = v.findViewById(R.id.youtubePlayerView);
        //initializeYouTube(youTubePlayerView);

        workoutList = new ArrayList<>();
        setWorkoutList();
        /*sets up the RecyclerView and it's adapter*/
        //Get reference to recycler view
        rvWorkout = (RecyclerView) v.findViewById(R.id.rvWorkout);
        //set layout manager
        rvWorkout.setLayoutManager(new LinearLayoutManager(getActivity()));
        //create an adapter
        WorkoutAdapter workoutAdapter = new WorkoutAdapter(workoutList);
        //set the adapter
        rvWorkout.setAdapter(workoutAdapter);
        //set item animator to Default animator
        rvWorkout.setItemAnimator(new DefaultItemAnimator());


        /*sets up the HorizontalCalendar*/
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

    //temporaty function to hardcode some values
    //TODO: get the data from our database
    private void setWorkoutList(){
        workoutList.add(new WorkoutItem("pushup"));
        workoutList.add(new WorkoutItem("sit up"));
        workoutList.add(new WorkoutItem("weights"));
    }

    private void initializeYouTube(YouTubePlayerView youTubePlayerView){
        youTubePlayerView.initialize(YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d("WorkoutFragment", "onInitializationSuccess");
                youTubePlayer.cueVideo("tKodtNFpzBA");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d("WorkoutFragment", "onInitializationFailure");
            }
        });
    }
}