package com.example.fitnest.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnest.NutritionCardview;
import com.example.fitnest.R;

import java.util.ArrayList;

public class NutritionAdapter extends RecyclerView.Adapter<NutritionAdapter.NutritionViewHolder> {
    public ArrayList<NutritionCardview> nutritionCardviewArrayList;

    public static class NutritionViewHolder extends RecyclerView.ViewHolder{
        public TextView nTextView1;
        public NutritionViewHolder(@NonNull View itemView) {
            super(itemView);
            nTextView1 = itemView.findViewById(R.id.cardtext);
        }
    }

    public NutritionAdapter(ArrayList<NutritionCardview> MealList) {
        nutritionCardviewArrayList = MealList;
    }


    @NonNull
    @Override
    public NutritionViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nutritionitem,parent,false);
        NutritionViewHolder nvh = new NutritionViewHolder(v);
        return nvh;
    }

    @Override
    public void onBindViewHolder( NutritionViewHolder holder, int position) {
        NutritionCardview currentItem = nutritionCardviewArrayList.get(position);

        holder.nTextView1.setText(currentItem.getNcText());
    }

    @Override
    public int getItemCount() {
        return nutritionCardviewArrayList.size();
    }
}
