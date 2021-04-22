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

import com.example.fitnest.AccomplishedItem;
import com.example.fitnest.ToAccomplishItem;
import com.example.fitnest.R;

import java.util.ArrayList;

public class AccomplishedGoalsAdapter extends RecyclerView.Adapter<AccomplishedGoalsAdapter.ViewHolder>{
    Context context;
    private ArrayList<AccomplishedItem> accomplishmentList;

    public AccomplishedGoalsAdapter(Context context, ArrayList<AccomplishedItem> accomplishmentList){
        this.context = context;
        this.accomplishmentList = accomplishmentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("AccomplishedGoalsAdapter", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accomplished_goals, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String acc = accomplishmentList.get(position).getAccomplishment();
        holder.tvAccomplishment.setText(acc);
    }

    @Override
    public int getItemCount() {
        return accomplishmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvAccomplishment;
        ConstraintLayout accomplishmentItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAccomplishment = itemView.findViewById(R.id.tvAccomplishment);
            accomplishmentItem = itemView.findViewById(R.id.accomplishment);
        }
    }
}

