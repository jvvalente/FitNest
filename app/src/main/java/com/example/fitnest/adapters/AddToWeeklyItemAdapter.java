package com.example.fitnest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnest.DailyPlanItem;
import com.example.fitnest.R;

import java.util.ArrayList;

public class AddToWeeklyItemAdapter extends RecyclerView.Adapter<AddToWeeklyItemAdapter.ViewHolder>{
    Context context;
    private ArrayList<DailyPlanItem> exerciseList;

    public AddToWeeklyItemAdapter(ArrayList<DailyPlanItem> exerciseList){
        this.exerciseList = exerciseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String workout = exerciseList.get(position).getExerciseType();
        holder.tvExerciseType.setText(workout);
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvExerciseType;
        ConstraintLayout exerciseItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvExerciseType = itemView.findViewById(R.id.tvExerciseType);
            exerciseItem = itemView.findViewById(R.id.exerciseItem);
        }
    }
}

