package com.example.asus.sleephelper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class RepeatingAlarm extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context,"闹钟响了",Toast.LENGTH_SHORT).show();
    }
}
