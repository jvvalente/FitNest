package com.example.fitnest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnest.R;
import com.example.fitnest.WorkoutItem;

import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.ViewHolder>{

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
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvWorkoutType;
        TextView tvWorkoutInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWorkoutType = itemView.findViewById(R.id.tvWorkoutType);
        }
    }
}

