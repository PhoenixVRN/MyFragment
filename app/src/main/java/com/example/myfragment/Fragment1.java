package com.example.myfragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class Fragment1 extends Fragment {
    private FragmentActivity activity;
    private LinearLayout b_1, b_2, b_3;
    private boolean start_stop = false;
    private Button button1;
    private int counter = 0;

    public Fragment1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        activity = getActivity();
        b_1 = activity.findViewById(R.id.Bulb_1);
        b_2 = activity.findViewById(R.id.Bulb_2);
        b_3 = activity.findViewById(R.id.Bulb_3);
        button1 = activity.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!start_stop) {
                    button1.setText("Stop");
                    start_stop = true;
                    newThread();


                } else {
                    start_stop = false;
                    button1.setText("Start");
                }
            }
        });

    }
    public void newThread() {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (start_stop) {
                    counter++;
                    switch (counter) {
                        case 1:
                            b_1.setBackgroundColor(Color.GREEN);
                            b_2.setBackgroundColor(Color.GRAY);
                            b_3.setBackgroundColor(Color.GRAY);
                            break;
                        case 2:
                            b_1.setBackgroundColor(Color.GRAY);
                            b_2.setBackgroundColor(Color.YELLOW);
                            b_3.setBackgroundColor(Color.GRAY);
                            break;
                        case 3:
                            b_1.setBackgroundColor(Color.GRAY);
                            b_2.setBackgroundColor(Color.GRAY);
                            b_3.setBackgroundColor(Color.RED);
                            counter = 0;
                            break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();

    }



}