package com.example.fitnest;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private int progress = 0;
    private ProgressBar progress_bar;
    private Button button_incr;
    private Button button_decr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        progress_bar = view.findViewById(R.id.progress_bar);
        button_incr = view.findViewById(R.id.button_incr);
        button_decr = view.findViewById(R.id.button_decr);
        TextView date = view.findViewById(R.id.date_textview);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        //progress_bar.setProgress(0);

        date.setText(currentDate);

        updateProgressBar();
        button_incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (progress <= 90) {
                    progress += 10;
                    updateProgressBar();
                }
                System.out.println("hellooooooooo");

            }
        });
        button_decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (progress >= 10) {
                    progress -= 10;
                    updateProgressBar();
                }
                System.out.println("hellooooooooo1");

            }
        });
    }

    private void updateProgressBar() {
        //progress_bar.setProgress(progress);
        //text_view_progress.text = "$progr%"

        // set the progress
        progress_bar.setProgress(progress);
        System.out.println("Progress: " + progress_bar.getProgress());
        // thread is used to change the progress value
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                updateProgressBar();
            }
        });
        thread.start();

    }
}