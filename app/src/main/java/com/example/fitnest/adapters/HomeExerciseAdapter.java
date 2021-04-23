package com.example.fitnest.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import com.example.fitnest.PersonalPlans;
import com.example.fitnest.R;
import com.example.fitnest.models.SingleExercise;

import java.util.List;

public class HomeExerciseAdapter extends RecyclerView.Adapter<HomeExerciseAdapter.ViewHolder> {

    private List<SingleExercise> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public HomeExerciseAdapter(Context context, List<SingleExercise> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_home_workout, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SingleExercise animal = mData.get(position);
        holder.myTextView.setText(animal.getExerciseName());
        holder.Sets.setText("Sets: " + animal.getExeeciseSets());
        holder.Reps.setText("Reps: " + animal.getExerciseReps());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        TextView Sets;
        TextView Reps;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvWorkoutName);
            Sets = itemView.findViewById(R.id.textViewSets);
            Reps = itemView.findViewById(R.id.textViewReps);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            //System.out.println("This works!" + getAdapterPosition() + " " + getItem(getAdapterPosition()));


        }
    }

    // convenience method for getting data at click position
    /*String getItem(int id) {
        return mData.get(id);
    }*/

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


}