package com.example.asus.sleephelper;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.Button;


public class soundFragment extends Fragment {
    private Button btn_personcollection;
    public soundFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_sound,container,false);
        return rootView;
    }
    public void onViewCreated(View v,Bundle savedInstanceState) {
        super.onViewCreated(v,savedInstanceState);
//        btn_personcollection=(Button)v.findViewById(R.id.btn_personCollection);
//        btn_personcollection.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent it = new Intent();
//                it.setClass(getActivity(),PersonalCollectionActivity.class);
//                getActivity().startActivity(it);
//            }
//        });
    }
}
