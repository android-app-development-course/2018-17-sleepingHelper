package com.example.asus.sleephelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class reportFragment extends Fragment {
    MyHelper myHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_report,container,false);
        myHelper=new MyHelper(getActivity());

        SQLiteDatabase db;
        db=myHelper.getReadableDatabase();
        Cursor cursor=db.query("information",null,null,null,null,null,null);
        int resultCount=cursor.getCount();
        if(resultCount!=0) {

            ListView reportList=(ListView)view.findViewById(R.id.reportList);
            //组织数据源
            List<HashMap<String,String>> mylist=new ArrayList<HashMap<String, String>>();
            for(int i=0;i<resultCount;i++){
                cursor.moveToPosition(i);
                HashMap<String,String> map=new HashMap<String,String>();
                String betweentime=cursor.getString(cursor.getColumnIndex("betweentime"))+"min";
                String time=cursor.getString(cursor.getColumnIndex("year"))+"年"+
                        cursor.getString(cursor.getColumnIndex("month"))+"月"+
                        cursor.getString(cursor.getColumnIndex("date"))+"日";
                map.put("Title",betweentime);
                map.put("SubText",time);
                mylist.add(map);
            }

            SimpleAdapter adapter=new SimpleAdapter(
                    this.getContext(),
                    mylist,
                    R.layout.list_items,
                    new String[]{"Title","SubText"},
                    new int[]{R.id.Title,R.id.SubText});
            reportList.setAdapter(adapter);
        }
        return view;
    }
}
