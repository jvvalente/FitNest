package com.example.fitnest;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnest.adapters.NutritionAdapter;

import java.util.ArrayList;

import static com.example.fitnest.R.layout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NutritionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NutritionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button button;
    private RecyclerView nRecyclerView;
    private RecyclerView.Adapter nAdapter;
    private RecyclerView.LayoutManager nLayoutManager;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NutritionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NutritionFragment newInstance(String param1, String param2) {
        NutritionFragment fragment = new NutritionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        ArrayList<NutritionCardview>  cardviews = new ArrayList<>();
        cardviews.add(new NutritionCardview("Meal"));

        nRecyclerView = nRecyclerView.findViewById(R.id.hc_events_recyclerView);
        nRecyclerView.setHasFixedSize(true);
        nAdapter = new NutritionAdapter(cardviews);
        nLayoutManager = new LinearLayoutManager(getActivity());
        nRecyclerView.setLayoutManager(nLayoutManager);
        nRecyclerView.setAdapter(nAdapter);
    */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(layout.fragment_nutrition, container,false);

        ArrayList<NutritionCardview>  cardviews = new ArrayList<>();
        cardviews.add(new NutritionCardview("Meal"));

        nRecyclerView = view.findViewById(R.id.recycler_view);
        nRecyclerView.setHasFixedSize(true);
        nAdapter = new NutritionAdapter(cardviews);
        nLayoutManager = new LinearLayoutManager(getActivity());
        nRecyclerView.setLayoutManager(nLayoutManager);
        nRecyclerView.setAdapter(nAdapter);



        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        button = (Button) view.findViewById(R.id.nutritionbutton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), Nutrition2.class);
                startActivity(intent);
            }
        });

        /*
        ArrayList<NutritionCardview>  cardviews = new ArrayList<>();
        cardviews.add(new NutritionCardview("Meal"));

        nRecyclerView = nRecyclerView.findViewById(R.id.recycler_view);
        nRecyclerView.setHasFixedSize(true);
        nAdapter = new NutritionAdapter(cardviews);
        nLayoutManager = new LinearLayoutManager(getActivity());
        nRecyclerView.setLayoutManager(nLayoutManager);
        nRecyclerView.setAdapter(nAdapter);
        */
    }

    public void openNutrition2(){
        Intent intent = new Intent(String.valueOf(Nutrition2.class));
        startActivity(intent);

    }
}
