package com.example.asus.sleephelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class daojishithreeactivity extends AppCompatActivity {

    private String string3="NULL";
    private String time3;
    private int totaltime;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daojishithreeactivity);
        Button btnCountTimer = (Button) findViewById(R.id.btnCountTimer3);
        TextView textView=(TextView)findViewById(R.id.d_text13);
        next=(Button)findViewById(R.id.bt3);
        Intent intent1=getIntent();
        string3=intent1.getStringExtra("string3");
        time3=intent1.getStringExtra("time3");
        if(!string3.equals("NULL")){
            totaltime=Integer.valueOf(time3).intValue();
            totaltime=totaltime*60*1000;
            textView.setText(string3);
            //倒计时总时间为10S，时间防止从9s开始显示
        }
        MyCountTimer myCountTimer = new MyCountTimer(totaltime, 1000, btnCountTimer);
        myCountTimer.start();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    finish();
            }
        });
    }
}
