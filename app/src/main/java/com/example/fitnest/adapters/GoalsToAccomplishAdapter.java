package com.example.fitnest.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnest.AddPersonalPlans;
import com.example.fitnest.ToAccomplishItem;
import com.example.fitnest.R;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.Arrays;

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
        Button doneButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAccomplishmentTo = itemView.findViewById(R.id.tvAccomplishmentTo);
            accomplishmentItem = itemView.findViewById(R.id.accomplishmentTo);
            doneButton = itemView.findViewById(R.id.buttonAccomplishment);

//            ParseObject done = new ParseObject("GoalsToAccomplish");
            ParseObject query1 = new ParseObject("AccomplishedGoals");

//            ParseQuery<ParseObject> query1 = ParseQuery.getQuery("AccomplishedGoals");
            ParseQuery<ParseObject> query2 = ParseQuery.getQuery("GoalsToAccomplish");
            query2.selectKeys(Arrays.asList("objectId"));

            doneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (!tvAccomplishmentTo.getText().toString().equals("")) {

                        query1.put("Goal", tvAccomplishmentTo.getText().toString());
                        query2.getInBackground("dSzjU7iBVz", (object, e) ->{
                            if(e == null){
                                object.deleteInBackground(e2 -> {
                                    if(e2 == null){

                                    }else{

                                    }
                                });
                            }else{

                            }
                        });

                        query1.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {

                                } else {}
                            }

                        });
                    }
                }
            });
        }
    }
}

