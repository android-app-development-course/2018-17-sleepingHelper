package com.example.asus.sleephelper;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class OneShotAlarm extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent){
        if(intent.getAction().equals("clockOn")) {
            Toast.makeText(context, "闹钟响了", Toast.LENGTH_LONG).show();
            Intent intent4 = new Intent(context, ringactivity.class);
            intent4.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent4);
        }
    }
}