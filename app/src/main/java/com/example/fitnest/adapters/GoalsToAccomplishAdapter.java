package com.example.fitnest.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnest.ToAccomplishItem;
import com.example.fitnest.R;
import com.example.fitnest.WorkoutItem;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoalsToAccomplishAdapter extends RecyclerView.Adapter<GoalsToAccomplishAdapter.ViewHolder>{

    private List<String> goals;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // NEW CODE
    Context context;
    ArrayList<ToAccomplishItem> goalList;

    public GoalsToAccomplishAdapter(Context context, List<String> data){
        this.mInflater = LayoutInflater.from(context);
        this.goals = data;
        this.context = context;
        this.goalList = goalList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = mInflater.inflate(R.layout.goals_to_accomplish, parent, false);

        Log.d("GoalsToAccomplishAdapter", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.goals_to_accomplish, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        String animal = mData.get(position);
//        holder.myTextView.setText(animal);
    }

    @Override
    public int getItemCount() {
        return goals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        ConstraintLayout goalItem;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvAccomplishmentTo);

            ParseQuery<ParseObject> query = ParseQuery.getQuery("User");
            query.selectKeys(Arrays.asList("Goal"));
            query.addDescendingOrder("Goal");

            goals = new ArrayList<>();

            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, ParseException e) {
                    if (e == null) {

                        for (ParseObject o: objects) {
                            System.out.println("ParseObject: " + o.get("Goal"));
                            goals.add(o.get("Goal").toString());
                        }

//                        Toast.makeText(ProgressActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    } else {
                        // Something is wrong
//                        Toast.makeText(ProgressActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            notifyItemChanged(getAdapterPosition());
        }
    }

    String getItem(int id) {
        return goals.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

