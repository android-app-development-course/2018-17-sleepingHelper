package com.example.asus.sleephelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class daojishitwoactivity extends AppCompatActivity {

    private String string2="NULL";
    private String string3="NULL";
    private String time2;
    private String time3;
    private int totaltime;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daojishitwoactivity);
        Button btnCountTimer = (Button) findViewById(R.id.btnCountTimer2);
        TextView textView=(TextView)findViewById(R.id.d_text12);
        next=(Button)findViewById(R.id.bt2);
        Intent intent1=getIntent();
        string2=intent1.getStringExtra("string2");
        string3=intent1.getStringExtra("string3");
        time2=intent1.getStringExtra("time2");
        time3=intent1.getStringExtra("time3");
        if(!string2.equals("NULL")){
            totaltime=Integer.valueOf(time2).intValue();
            totaltime=totaltime*60*1000;
            textView.setText(string2);
            //倒计时总时间为10S，时间防止从9s开始显示
        }
        MyCountTimer myCountTimer = new MyCountTimer(totaltime, 1000, btnCountTimer);
        myCountTimer.start();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!string3.equals("NULL"))
                {
                    finish();
                    f();
                }
                else finish();
            }
        });
    }
    public void f()
    {
        Intent intent =new Intent(this,daojishithreeactivity.class);
        intent.putExtra("string3",string3);
        intent.putExtra("time3",time3);
        startActivity(intent);
    }
}
