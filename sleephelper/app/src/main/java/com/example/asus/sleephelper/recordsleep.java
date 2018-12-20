package com.example.asus.sleephelper;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.asus.sleephelper.activity.BActivity;
import com.example.asus.sleephelper.activity.MainActivity;

import java.util.Calendar;

public class recordsleep extends AppCompatActivity {

    MyHelper myHelper;
    private int hour1;
    private int minute1;
    private int day1;
    private int month1;
    private int year1;
    private int hour2;
    private int minute2;
    private int day2;
    private int month2;
    private int year2;
    private long betweentime;
    private Button endsleep;
    private int time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordsleep);
        myHelper=new MyHelper(this);
        endsleep=(Button)findViewById(R.id.endsleep);
        final Intent intent=getIntent();
        year1=intent.getIntExtra("Year",0);
        month1=intent.getIntExtra("Month",0);
        day1=intent.getIntExtra("Date",0);
        hour1=intent.getIntExtra("Hour",0);
        minute1=intent.getIntExtra("Minute",0);

        endsleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               fun();
            }
        });
    }
    public void fun()
    {
        SQLiteDatabase db;
        ContentValues values;
        Calendar c=Calendar.getInstance();
        day2=c.get(Calendar.DAY_OF_MONTH);
        hour2=c.get(Calendar.HOUR);
        minute2=c.get(Calendar.MINUTE);
        month2=c.get(Calendar.MONTH);
        year2=c.get(Calendar.YEAR);
        Calendar beginCalendar=Calendar.getInstance();
        beginCalendar.set(year1,month1,day1,hour1,minute1,0);
        Calendar endCalendar=Calendar.getInstance();
        endCalendar.set(year2,month2,day2,hour2,minute2,0);
        long beginTime = beginCalendar.getTime().getTime();
        long endTime = endCalendar.getTime().getTime();
        betweentime=(long)((endTime-beginTime)/(1000*60));
        MyApplication application=(MyApplication)this.getApplication();
        int flag=application.getId();
        application.setId(flag+1);
        db=myHelper.getWritableDatabase();
        values=new ContentValues();
        String s1 = String.valueOf(flag);
        String s2 = String.valueOf(betweentime);
        values.put("_id",s1);
        values.put("betweentime",s2);
        values.put("sign",0);
        values.put("year",year1);
        values.put("month",month1);
        values.put("date",day1);
        values.put("hour",hour1);
        values.put("minute",minute1);
        db.insert("information",null,values);
        db.close();
    }
}
