package com.example.asus.sleephelper;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class daojishioneactivity extends AppCompatActivity {
    private String string1="NULL";
    private String string2="NULL";
    private String string3="NULL";
    private String time1;
    private String time2;
    private String time3;
    private int totaltime;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daojishioneactivity);
        Button btnCountTimer = (Button) findViewById(R.id.btnCountTimer);
        TextView textView=(TextView)findViewById(R.id.d_text1);
        next=(Button)findViewById(R.id.bt);
        Intent intent1=getIntent();
        string1=intent1.getStringExtra("string1");
        string2=intent1.getStringExtra("string2");
        string3=intent1.getStringExtra("string3");
        time1=intent1.getStringExtra("time1");
        time2=intent1.getStringExtra("time2");
        time3=intent1.getStringExtra("time3");
        if(!string1.equals("NULL")){
           totaltime=Integer.valueOf(time1).intValue();
           totaltime=totaltime*60*1000;
            textView.setText(string1);
            //倒计时总时间为10S，时间防止从9s开始显示
        }
        MyCountTimer myCountTimer = new MyCountTimer(totaltime, 1000, btnCountTimer);
        myCountTimer.start();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!string2.equals("NULL"))
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
        Intent intent =new Intent(this,daojishitwoactivity.class);
        intent.putExtra("string2",string2);
        intent.putExtra("time2",time2);
        intent.putExtra("string3",string3);
        intent.putExtra("time3",time3);
        startActivity(intent);
    }
}
//https://blog.csdn.net/u014005316/article/details/62037079
//https://blog.csdn.net/donkor_/article/details/53305130