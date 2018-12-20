package com.example.asus.sleephelper;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.IOException;
import java.util.Calendar;

public class clockactivity extends AppCompatActivity {

    private TextView setone;
    private TextView settwo;
    private TextView setthree;
    private TextView showtimeone;
    private TextView showtimetwo;
    private TextView showtimethree;
    private ImageView ten;
    private ImageView twenty;
    private ImageView fourty;
    private ImageView ninety;
    private int flag1=0;
    private int flag2=0;
    private int flag3=0;
    private int flag4=0;
    private static final int INTERVAL = 1000 * 60 * 60 * 24;// 24h
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clockactivity);
        setone=(TextView)findViewById(R.id.setone);
        settwo=(TextView)findViewById(R.id.settwo);
        setthree=(TextView)findViewById(R.id.setthree);
        showtimeone=(TextView)findViewById(R.id.showtimeone);
        showtimetwo=(TextView)findViewById(R.id.showtimetwo);
        showtimethree=(TextView)findViewById(R.id.showtimethree);
        ten=(ImageView)findViewById(R.id.iv_ten);
        twenty=(ImageView)findViewById(R.id.iv_twenty_four);
        fourty=(ImageView)findViewById(R.id.iv_fourty);
        ninety=(ImageView)findViewById(R.id.iv_ninety);
        setone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(clockactivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        showtimeone.setText(String.format("%d:%d",hourOfDay,minute));
                        Calendar c=Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        Intent intent = new Intent(clockactivity.this, OneShotAlarm.class);
                        PendingIntent sender = PendingIntent.getBroadcast(
                                clockactivity.this, 0, intent, 0);
                        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                        am.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),INTERVAL, sender);
                    }
                    //0,0指的是时间，true表示是否为24小时，true为24小时制
                },0,0,true).show();
            }
        });
        settwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(clockactivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        showtimetwo.setText(String.format("%d:%d",hourOfDay,minute));
                        Calendar c=Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        Intent intent = new Intent(clockactivity.this, OneShotAlarm.class);
                        PendingIntent sender = PendingIntent.getBroadcast(
                                clockactivity.this, 1, intent, 0);
                        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                        am.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),INTERVAL, sender);
                    }
                    //0,0指的是时间，true表示是否为24小时，true为24小时制
                },0,0,true).show();
            }
        });
        setthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(clockactivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        showtimethree.setText(String.format("%d:%d",hourOfDay,minute));
                        Calendar c=Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        Intent intent = new Intent(clockactivity.this, OneShotAlarm.class);
                        PendingIntent sender = PendingIntent.getBroadcast(
                                clockactivity.this, 01, intent, 0);
                        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                        am.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),INTERVAL, sender);
                    }
                    //0,0指的是时间，true表示是否为24小时，true为24小时制
                },0,0,true).show();
            }
        });
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1=flag1+1;
                if((flag1%2)!=0) {
                    Intent intent = new Intent(clockactivity.this,
                            RepeatingAlarm.class);
                    PendingIntent sender = PendingIntent.getBroadcast(
                            clockactivity.this, 10, intent, 0);

                    // We want the alarm to go off 10 seconds from now.
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    calendar.add(Calendar.MINUTE, 10);
                    // Schedule the alarm!
                    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.set(AlarmManager.RTC_WAKEUP,
                            calendar.getTimeInMillis(), sender);
                    Toast.makeText(clockactivity.this, "设定成功，闹钟将于10分钟后响起", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(clockactivity.this, OneShotAlarm.class);
                    PendingIntent sender = PendingIntent.getBroadcast(
                            clockactivity.this, 10, intent, 0);
                    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.cancel(sender);
                    Toast.makeText(clockactivity.this, "闹钟取消成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        twenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag2=flag2+1;
                if((flag2%2)!=0) {
                Intent intent = new Intent(clockactivity.this,
                        RepeatingAlarm.class);
                PendingIntent sender = PendingIntent.getBroadcast(
                        clockactivity.this, 101, intent, 0);

                // We want the alarm to go off 10 seconds from now.
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(Calendar.MINUTE, 24);
                // Schedule the alarm!
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis(), sender);
                Toast.makeText(clockactivity.this,"设定成功，闹钟将于24分钟后响起",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(clockactivity.this, OneShotAlarm.class);
                    PendingIntent sender = PendingIntent.getBroadcast(
                            clockactivity.this, 101, intent, 0);
                    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.cancel(sender);
                    Toast.makeText(clockactivity.this, "闹钟取消成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        fourty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag3=flag3+1;
                if((flag3%2)!=0) {
                Intent intent = new Intent(clockactivity.this,
                        RepeatingAlarm.class);
                PendingIntent sender = PendingIntent.getBroadcast(
                        clockactivity.this, 110, intent, 0);

                // We want the alarm to go off 10 seconds from now.
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(Calendar.MINUTE, 40);
                // Schedule the alarm!
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis(), sender);
                Toast.makeText(clockactivity.this,"设定成功，闹钟将于40分钟后响起",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(clockactivity.this, OneShotAlarm.class);
                    PendingIntent sender = PendingIntent.getBroadcast(
                            clockactivity.this, 110, intent, 0);
                    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.cancel(sender);
                    Toast.makeText(clockactivity.this, "闹钟取消成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ninety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag4 = flag4 + 1;
                if ((flag4 % 2) != 0) {
                    Intent intent = new Intent(clockactivity.this,
                            RepeatingAlarm.class);
                    PendingIntent sender = PendingIntent.getBroadcast(
                            clockactivity.this, 1101, intent, 0);

                    // We want the alarm to go off 10 seconds from now.
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    calendar.add(Calendar.MINUTE, 90);
                    // Schedule the alarm!
                    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.set(AlarmManager.RTC_WAKEUP,
                            calendar.getTimeInMillis(), sender);
                    Toast.makeText(clockactivity.this, "设定成功，闹钟将于90分钟后响起", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(clockactivity.this, OneShotAlarm.class);
                    PendingIntent sender = PendingIntent.getBroadcast(
                            clockactivity.this, 1101, intent, 0);
                    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.cancel(sender);
                    Toast.makeText(clockactivity.this, "闹钟取消成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
