package com.example.asus.sleephelper;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class routinetwoactivity extends AppCompatActivity {

    private TextView reset;
    private TextView showtime;
    private int hour;
    private int min;
    private Switch sw1;
    private Switch sw2;
    private static final int INTERVAL = 1000 * 60 * 60 * 24;// 24h
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routinetwoactivity);
        reset=(TextView) this.findViewById(R.id.reset);
        showtime= (TextView) this.findViewById(R.id.showtime);
        sw1=(Switch)findViewById(R.id.sw1);
        sw2=(Switch)findViewById(R.id.sw2);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(routinetwoactivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        showtime.setText(String.format("%d:%d",hourOfDay,minute));
                        hour=hourOfDay;
                        min=minute;
                        Calendar c=Calendar.getInstance();
                        c.setTimeInMillis(System.currentTimeMillis());
                        if(c.get(Calendar.HOUR_OF_DAY)>hourOfDay)
                        {
                            c.add(Calendar.DATE,1);
                        }
                        else if(c.get(Calendar.HOUR_OF_DAY)==hourOfDay)
                        {
                            if(c.get(Calendar.MINUTE)>=minute)
                            {
                                c.add(Calendar.DATE,1);
                            }
                        }
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        Intent intent = new Intent(routinetwoactivity.this, OneShotAlarm.class);
                        PendingIntent sender = PendingIntent.getBroadcast(
                                routinetwoactivity.this, 0x101, intent, 0);
                        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                        am.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),INTERVAL, sender);
                        Toast.makeText(routinetwoactivity.this, "闹钟设置成功", Toast.LENGTH_SHORT).show();
                    }
                    //0,0指的是时间，true表示是否为24小时，true为24小时制
                },0,0,true).show();
            }
        });

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sw1.isChecked())
                {
                    //设置SP
                    Calendar c=Calendar.getInstance();
                    c.setTimeInMillis(System.currentTimeMillis());
                    if(c.get(Calendar.HOUR_OF_DAY)>hour)
                    {
                        c.add(Calendar.DATE,1);
                    }
                    else if(c.get(Calendar.HOUR_OF_DAY)==hour)
                    {
                        if(c.get(Calendar.MINUTE)>=min)
                        {
                            c.add(Calendar.DATE,1);
                        }
                    }
                    c.set(Calendar.HOUR_OF_DAY,hour);
                    c.set(Calendar.MINUTE,min);
                    c.add(Calendar.MINUTE,-45);
                    Intent intent = new Intent(routinetwoactivity.this, OneShotAlarm.class);
                    PendingIntent sender = PendingIntent.getBroadcast(
                            routinetwoactivity.this, 0001, intent, 0);
                    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),INTERVAL, sender);
                    Toast.makeText(routinetwoactivity.this, "睡前准备提醒开启成功", Toast.LENGTH_SHORT).show();
                }else{
                    //设置SP
                    Intent intent = new Intent(routinetwoactivity.this, OneShotAlarm.class);
                    PendingIntent sender = PendingIntent.getBroadcast(
                            routinetwoactivity.this, 0001, intent, 0);
                    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.cancel(sender);
                    Toast.makeText(routinetwoactivity.this, "睡前准备提醒取消成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sw2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sw2.isChecked())
                {
                    //设置SP
                    Calendar c=Calendar.getInstance();
                    c.setTimeInMillis(System.currentTimeMillis());
                    if(c.get(Calendar.HOUR_OF_DAY)>hour)
                    {
                        c.add(Calendar.DATE,1);
                    }
                    else if(c.get(Calendar.HOUR_OF_DAY)==hour)
                    {
                        if(c.get(Calendar.MINUTE)>=min)
                        {
                            c.add(Calendar.DATE,1);
                        }
                    }
                    c.set(Calendar.HOUR_OF_DAY,hour);
                    c.set(Calendar.MINUTE,min);
                    Intent intent = new Intent(routinetwoactivity.this, OneShotAlarm.class);
                    PendingIntent sender = PendingIntent.getBroadcast(
                            routinetwoactivity.this, 0x101, intent, 0);
                    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),1000*60*10, sender);
                    Toast.makeText(routinetwoactivity.this, "严格模式开启成功", Toast.LENGTH_SHORT).show();
                }else{
                    //设置SP
                    Intent intent = new Intent(routinetwoactivity.this, OneShotAlarm.class);
                    PendingIntent sender = PendingIntent.getBroadcast(
                            routinetwoactivity.this, 0x101, intent, 0);
                    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.cancel(sender);
                    Calendar c=Calendar.getInstance();
                    c.setTimeInMillis(System.currentTimeMillis());
                    if(c.get(Calendar.HOUR_OF_DAY)>hour)
                    {
                        c.add(Calendar.DATE,1);
                    }
                    else if(c.get(Calendar.HOUR_OF_DAY)==hour)
                    {
                        if(c.get(Calendar.MINUTE)>=min)
                        {
                            c.add(Calendar.DATE,1);
                        }
                    }
                    c.set(Calendar.HOUR_OF_DAY,hour);
                    c.set(Calendar.MINUTE,min);
                    am.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),INTERVAL, sender);
                    Toast.makeText(routinetwoactivity.this, "严格模式取消成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
