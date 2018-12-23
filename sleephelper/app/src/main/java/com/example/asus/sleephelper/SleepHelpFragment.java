package com.example.asus.sleephelper;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SleepHelpFragment extends Fragment {
    private Button btn_music1;
    private Button btn_music2;
    private Button btn_music3;
    private Button btn_music4;
    private Button btn_music5;
    public SleepHelpFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_sleephelp,container,false);
        btn_music1=(Button)view.findViewById(R.id.on1);
        btn_music2=(Button)view.findViewById(R.id.on2);
        btn_music3=(Button)view.findViewById(R.id.on3);
        btn_music4=(Button)view.findViewById(R.id.on4);
        btn_music5=(Button)view.findViewById(R.id.on5);
        btn_music1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(getActivity(), MusicShowActivity.class);
                it.putExtra("num",0);
                getActivity().startActivity(it);
                //Toast.makeText(getActivity(),"hello world",Toast.LENGTH_SHORT).show();
            }
        });
        btn_music2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(getActivity(), MusicShowActivity.class);
                it.putExtra("num",1);
                getActivity().startActivity(it);
                //Toast.makeText(getActivity(),"hello world",Toast.LENGTH_SHORT).show();
            }
        });
        btn_music3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(getActivity(), MusicShowActivity.class);
                it.putExtra("num",2);
                getActivity().startActivity(it);
                //Toast.makeText(getActivity(),"hello world",Toast.LENGTH_SHORT).show();
            }
        });
        btn_music4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(getActivity(), MusicShowActivity.class);
                it.putExtra("num",3);
                getActivity().startActivity(it);
                //Toast.makeText(getActivity(),"hello world",Toast.LENGTH_SHORT).show();
            }
        });
        btn_music5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(getActivity(), MusicShowActivity.class);
                it.putExtra("num",4);
                getActivity().startActivity(it);
                //Toast.makeText(getActivity(),"hello world",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
