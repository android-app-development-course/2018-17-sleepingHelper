package com.example.asus.sleephelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
    private Button startrecord;
    private Button endrecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordsleep);
        myHelper=new MyHelper(this);
        startrecord=(Button)findViewById(R.id.startrecord);
        endrecord=(Button)findViewById(R.id.endrecord);
        endrecord.setEnabled(false);

        startrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startRecord();
            }
        });

        endrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endRecord();
            }
        });
    }

    public void startRecord(){
        Calendar c=Calendar.getInstance();
        day1=c.get(Calendar.DAY_OF_MONTH);
        hour1=c.get(Calendar.HOUR);
        minute1=c.get(Calendar.MINUTE);
        month1=c.get(Calendar.MONTH)+1;
        year1=c.get(Calendar.YEAR);
        startrecord.setEnabled(false);
        endrecord.setEnabled(true);
    }

    public void endRecord() {
        SQLiteDatabase db;
        ContentValues values;
        Calendar c=Calendar.getInstance();
        day2=c.get(Calendar.DAY_OF_MONTH);
        hour2=c.get(Calendar.HOUR);
        minute2=c.get(Calendar.MINUTE);
        month2=c.get(Calendar.MONTH)+1;
        year2=c.get(Calendar.YEAR);
        Calendar beginCalendar=Calendar.getInstance();
        beginCalendar.set(year1,month1,day1,hour1,minute1,0);
        Calendar endCalendar=Calendar.getInstance();
        endCalendar.set(year2,month2,day2,hour2,minute2,0);
        long beginTime = beginCalendar.getTime().getTime();
        long endTime = endCalendar.getTime().getTime();
        betweentime=(long)(((double)(endTime-beginTime))/(1000*60));
        db=myHelper.getWritableDatabase();
        values=new ContentValues();
        values.put("betweentime",String.valueOf(betweentime));
        values.put("year",year1);
        values.put("month",month1);
        values.put("date",day1);
        values.put("hour",hour1);
        values.put("minute",minute1);
        db.insert("information",null,values);
        db.close();
        endrecord.setEnabled(false);
        Toast.makeText(getApplicationContext(), "记录完成！", Toast.LENGTH_LONG).show();
    }
}
