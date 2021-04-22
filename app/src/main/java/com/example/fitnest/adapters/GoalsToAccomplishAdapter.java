package com.example.fitnest.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnest.ToAccomplishItem;
import com.example.fitnest.R;

import java.util.ArrayList;

public class GoalsToAccomplishAdapter extends RecyclerView.Adapter<GoalsToAccomplishAdapter.ViewHolder>{
    Context context;
    private ArrayList<ToAccomplishItem> accomplishmentList;

    public GoalsToAccomplishAdapter(Context context, ArrayList<ToAccomplishItem> accomplishmentList){
        this.context = context;
        this.accomplishmentList = accomplishmentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("GoalsToAccomplishAdapter", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.goals_to_accomplish, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String acc = accomplishmentList.get(position).getAccomplishment();
        holder.tvAccomplishmentTo.setText(acc);
    }

    @Override
    public int getItemCount() {
        return accomplishmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvAccomplishmentTo;
        ConstraintLayout accomplishmentItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAccomplishmentTo = itemView.findViewById(R.id.tvAccomplishmentTo);
            accomplishmentItem = itemView.findViewById(R.id.accomplishmentTo);
        }
    }
}

