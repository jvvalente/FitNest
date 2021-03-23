package com.example.fitnest.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnest.R;
import com.example.fitnest.WorkoutItem;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.ViewHolder>{
    public static final String YOUTUBE_API_KEY = "AIzaSyAIF6220mZ2d1v53FU7cvOeSh2as1kmT44";
    Context context;
    private ArrayList<WorkoutItem> workoutList;

    public WorkoutAdapter(ArrayList<WorkoutItem> workoutList){
        this.workoutList = workoutList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String workout = workoutList.get(position).getWorkoutType();
        holder.tvWorkoutType.setText(workout);

        boolean isExpanded = workoutList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvWorkoutType;
        TextView tvWorkoutInfo;
        NumberPicker numberPicker;
        YouTubePlayerView youTubePlayerView;
        ConstraintLayout workoutItem;
        ConstraintLayout expandableLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWorkoutType = itemView.findViewById(R.id.tvWorkoutType);
            setNumberPicker(itemView);
            //initializeYouTube(itemView);
            workoutItem = itemView.findViewById(R.id.workoutItem);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);

            workoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WorkoutItem workout = workoutList.get(getAdapterPosition());
                    workout.setExpanded(!workout.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }

        //sets the number picker
        private void setNumberPicker(View itemView) {
            numberPicker = itemView.findViewById(R.id.numberPicker);
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(10);
            numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                }
            });
        }

        /*
        //initalizes the YoutTubePlayerView
        private void initializeYouTube(View itemView){
            youTubePlayerView = itemView.findViewById(R.id.youtubePlayerView);
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

         */
    }
}

