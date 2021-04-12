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
    /*
    Note to self- need to conver the YouTubePlayerView to YouTubePlayerFragment
    https://www.androhub.com/implement-youtube-player-fragment-android-app/
     */
    public static final String YOUTUBE_API_KEY = "AIzaSyAIF6220mZ2d1v53FU7cvOeSh2as1kmT44";
    Context context;
    ArrayList<WorkoutItem> workoutList;

    public WorkoutAdapter(Context context, ArrayList<WorkoutItem> workoutList){
        this.context = context;
        this.workoutList = workoutList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("WorkoutAdapter", "onCreateViewHolder");
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
        TextView setsCompleted;
        TextView repsCompleted;
        NumberPicker numberPickerSets;
        NumberPicker numberPickerReps;
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

        //sets both number picker
        private void setNumberPicker(View itemView) {
            setsCompleted = itemView.findViewById(R.id.setsCompleted);
            repsCompleted = itemView.findViewById(R.id.repsCompleted);

            numberPickerSets = itemView.findViewById(R.id.numberPickerSets);
            numberPickerSets.setMinValue(0);
            numberPickerSets.setMaxValue(10);
            numberPickerSets.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    setsCompleted.setText("" + newVal);
                }
            });

            numberPickerReps = itemView.findViewById(R.id.numberPickerReps);
            numberPickerReps.setMinValue(0);
            numberPickerReps.setMaxValue(10);
            numberPickerReps.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    repsCompleted.setText("" + newVal);
                }
            });
        }

//        //initalizes the YoutTubePlayerView
//        private void initializeYouTube(View itemView){
//            youTubePlayerView = itemView.findViewById(R.id.youtubePlayerView);
//            youTubePlayerView.initialize(YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
//                @Override
//                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                    Log.d("WorkoutAdapter", "onInitializationSuccess");
//                    //do any work to play the video here, currently just playing a random video
//                    youTubePlayer.cueVideo("Eh00_rniF8E");
//                }
//
//                @Override
//                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//                    Log.d("WorkoutAdapter", "onInitializationFailure");
//                }
//            });
//        }
    }
}

