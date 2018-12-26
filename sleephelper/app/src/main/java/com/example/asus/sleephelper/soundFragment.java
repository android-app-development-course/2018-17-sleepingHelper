package com.example.asus.sleephelper;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class soundFragment extends Fragment{
    private ImageButton imageButton1_1;
    private ImageButton imageButton1_2;
    private ImageButton imageButton1_3;
    private ImageButton imageButton1_4;

    private ImageButton imageButton2_1;
    private ImageButton imageButton2_2;
    private ImageButton imageButton2_3;
    private ImageButton imageButton2_4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sound,null);
        imageButton1_1=(ImageButton)view.findViewById(R.id.imageButton1_1);
        imageButton1_2=(ImageButton)view.findViewById(R.id.imageButton1_2);
        imageButton1_3=(ImageButton)view.findViewById(R.id.imageButton1_3);
        imageButton1_4=(ImageButton)view.findViewById(R.id.imageButton1_4);

        imageButton2_1=(ImageButton)view.findViewById(R.id.imageButton2_1);
        imageButton2_2=(ImageButton)view.findViewById(R.id.imageButton2_2);
        imageButton2_3=(ImageButton)view.findViewById(R.id.imageButton2_3);
        imageButton2_4=(ImageButton)view.findViewById(R.id.imageButton2_4);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        imageButton1_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                webActivity.url="https://www.psy-1.com/mob/home/wenjuan/46";
                Intent intent1=new Intent(getActivity(), webActivity.class);
                getActivity().startActivity(intent1);
            }
        });

        imageButton1_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                webActivity.url="https://mp.weixin.qq.com/s?__biz=MzAxNjU3MjMzOQ==&mid=504115715&idx=1&sn=01b86c783dd71f6a117d6c9f2636d425&chksm=000a58df377dd1c93c0ccd1514c7c1d0926a487f03e1483bf56e427ec1fc05831be9f5c8f847#rd";
                Intent intent1=new Intent(getActivity(), webActivity.class);
                getActivity().startActivity(intent1);
            }
        });

        imageButton1_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                webActivity.url="https://mp.weixin.qq.com/s?__biz=MzAxNjU3MjMzOQ==&mid=504115711&idx=1&sn=cc6c06e097bfac5a9922eead276fd9f5&chksm=000a5b23377dd235f38f1bd58cd4cf0ce4b3095c42ebed632c58aa7bbbab4aa3edf3b1e9ae65#rd";
                Intent intent1=new Intent(getActivity(), webActivity.class);
                getActivity().startActivity(intent1);
            }
        });

        imageButton1_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                webActivity.url="https://mp.weixin.qq.com/s?__biz=MzAxNjU3MjMzOQ==&mid=504115707&idx=1&sn=e0955eae2a7af1cdedd66b68ab8bd432&chksm=000a5b27377dd2318296ba272d4533ddaa7fd407660472f7c8edb46043c9bbcdea2b3e409cdf#rd";
                Intent intent1=new Intent(getActivity(), webActivity.class);
                getActivity().startActivity(intent1);
            }
        });

        imageButton2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), MusicShowActivity.class);
                it.putExtra("num",0);
                getActivity().startActivity(it);
            }
        });

        imageButton2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), MusicShowActivity.class);
                it.putExtra("num",1);
                getActivity().startActivity(it);
            }
        });

        imageButton2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), MusicShowActivity.class);
                it.putExtra("num",2);
                getActivity().startActivity(it);
            }
        });

        imageButton2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), MusicShowActivity.class);
                it.putExtra("num",3);
                getActivity().startActivity(it);
            }
        });
    }



}
