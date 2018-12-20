package com.example.asus.sleephelper.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.sleephelper.R;

public class SleephelpFragment extends Fragment {
    public View onCreatView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ){
        View view = inflater.inflate(R.layout.fragment_sleephelp, container, false);
        return view;
    }
}
