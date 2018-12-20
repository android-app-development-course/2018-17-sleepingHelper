package com.example.asus.sleephelper;

import android.content.ContentValues;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;


public class reportFragment extends Fragment {
    MyHelper myHelper;
    public reportFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_report,container,false);
        myHelper=new MyHelper(getActivity());
        MyApplication application=(MyApplication)getActivity().getApplication();
        int flag=application.getId()-1;
        int top1=application.getTop1();
        int top2=application.getTop2();
        String s = String.valueOf(flag);
        SQLiteDatabase db;
        ContentValues values;
        db=myHelper.getReadableDatabase();
        Cursor cursor=db.query("information",null,"_id=?",new String[]{s,},null,null,null);
        if(cursor.getCount()!=0&&!cursor.getString(2).equals("0"))
        {
            FrameLayout ll = (FrameLayout) view.findViewById(R.id.l1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics())),
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top1, getResources().getDisplayMetrics()),
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics()),
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics()));
            TextView tv = new TextView(getActivity());
            tv.setLayoutParams(layoutParams);
            tv.setText(cursor.getString(1)+"min");
            tv.setTextSize(40);
            tv.setTextColor((Color.rgb(240, 240, 240)));
            ll.addView(tv);

            layoutParams.setMargins(((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics())),
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top2, getResources().getDisplayMetrics()),
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics()),
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics()));
            TextView tv1 = new TextView(getActivity());
            tv1.setLayoutParams(layoutParams);
            tv1.setText(cursor.getString(3)+"年"+cursor.getString(4)+"月"+
                    cursor.getString(5)+"日"+cursor.getString(6)+":"+cursor.getString(7));
            tv1.setTextSize(20);
            tv1.setTextColor((Color.rgb(240, 240, 240)));
            ll.addView(tv1);
            application.setTop1(top1+100);
            application.setTop2(top2+100);
            //修改数据
        }
        return view;
    }
}
