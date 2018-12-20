package com.example.asus.sleephelper;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.asus.sleephelper.Fragment.routineactivity;

import java.util.Calendar;


public class RoutineFragment extends Fragment {
    private TextView textview_bianji1;
    private TextView textview_bianji2;
    private TextView clock;
    private Button recordsleep;
    private int date;
    private int hour;
    private int minute;
    private int year;
    private int month;
    public RoutineFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_routine,container,false);
       textview_bianji1=(TextView) view.findViewById(R.id.bianji1);
        textview_bianji2=(TextView) view.findViewById(R.id.bianji2);
        clock=(TextView)view.findViewById(R.id.clock);
        recordsleep=(Button)view.findViewById(R.id.recordsleep);
        textview_bianji1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), routineactivity.class);
               // intent.putExtra("position",position);
                getActivity().startActivity(intent1);
            }
        });
        textview_bianji2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), routinetwoactivity.class);
                // intent.putExtra("position",position);
                getActivity().startActivity(intent);
            }
        });
        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getActivity(), clockactivity.class);
                // intent.putExtra("position",position);
                getActivity().startActivity(intent2);
            }
        });
        recordsleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                year=c.get(Calendar.YEAR);
                month=c.get(Calendar.MONTH);
                date=c.get(Calendar.DAY_OF_MONTH);
                hour=c.get(Calendar.HOUR);
                minute=c.get(Calendar.MINUTE);
                Intent intent3=new Intent(getActivity(), recordsleep.class);
                intent3.putExtra("Month",month);
                intent3.putExtra("Year",year);
                intent3.putExtra("Date",date);
                intent3.putExtra("Hour",hour);
                intent3.putExtra("Minute",minute);
                getActivity().startActivity(intent3);
            }
        });
        return view;
    }
}
