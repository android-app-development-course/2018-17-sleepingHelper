package com.example.asus.sleephelper;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SleepHelpFragment extends Fragment {
    private ListView listView;
    String[] songName={"Born a Stranger","木陰","Dazing","Drip Drip Drip","Floating in the City","dear sleeper","微睡む月の夜のアリア 竖琴ver","夜空的寂静"};
    String[] singer={"Kan R. Gao","いろのみ","音乐治疗","音乐治疗","音乐治疗","Chima","Meandi鸦缺","赵海洋"};
    int [] icons={R.drawable.pone,R.drawable.ptwo,R.drawable.pthree,R.drawable.pthree,R.drawable.pthree,R.drawable.pfour,R.drawable.pfive,R.drawable.psix};
    public SleepHelpFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_sleephelp,container,false);
        listView=(ListView)view.findViewById(R.id.listView);
        List<Map<String, Object>> listems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < songName.length; i++) {
            Map<String, Object> listem = new HashMap<String, Object>();
            listem.put("songName", songName[i]);
            listem.put("singer", singer[i]);
            listem.put("icon", icons[i]);
            listems.add(listem);
        }
        SimpleAdapter simplead = new SimpleAdapter(getActivity(), listems,
                R.layout.list_items3, new String[] { "songName", "singer", "icon" },
                new int[] {R.id.title,R.id.author,R.id.image});

        listView=(ListView)view.findViewById(R.id.listView);
        listView.setAdapter(simplead);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(getActivity(), MusicShowActivity.class);
                intent.putExtra("num",arg2);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }

}
