package com.example.asus.sleephelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class beforesleepactivity extends Activity implements View.OnClickListener{

    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv_time1;
    private TextView tv_time2;
    private TextView tv_time3;
    private Button start;
    private String string1="NULL";
    private String string2="NULL";
    private String string3="NULL";
    private String time1;
    private String time2;
    private String time3;
    private int photo1;
    private int photo2;
    private int photo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beforesleepactivity);
        iv1=(ImageView)findViewById(R.id.photo1);
        iv2=(ImageView)findViewById(R.id.photo2);
        iv3=(ImageView)findViewById(R.id.photo3);
        tv1=(TextView)findViewById(R.id.string1);
        tv2=(TextView)findViewById(R.id.string2);
        tv3=(TextView)findViewById(R.id.string3);
        tv_time1=(TextView)findViewById(R.id.time1);
        tv_time2=(TextView)findViewById(R.id.time2);
        tv_time3=(TextView)findViewById(R.id.time3);
        start=(Button)findViewById(R.id.start);
        start.setOnClickListener(this);

        Intent intent=getIntent();
        string1=intent.getStringExtra("string1");
        string2=intent.getStringExtra("string2");
        string3=intent.getStringExtra("string3");
        time1=intent.getStringExtra("time1");
        time2=intent.getStringExtra("time2");
        time3=intent.getStringExtra("time3");
        photo1=intent.getIntExtra("photo1",0);
        photo2=intent.getIntExtra("photo2",0);
        photo3=intent.getIntExtra("photo3",0);
        if(!string1.equals("NULL"))
        {
            iv1.setImageResource(photo1);
            tv1.setText(string1);
            tv_time1.setText(time1+"min");
        }
        if(!string2.equals("NULL"))
        {
            iv2.setImageResource(photo2);
            tv2.setText(string2);
            tv_time2.setText(time2+"min");
        }
        if(!string3.equals("NULL"))
        {
            iv3.setImageResource(photo3);
            tv3.setText(string3);
            tv_time3.setText(time3+"min");
        }
    }
    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.start:
                if(string1.equals("NULL"))
                {
                    finish();
                    break;
                }
                Intent intent1 =new Intent(this,daojishioneactivity.class);
                intent1.putExtra("string1",string1);
                intent1.putExtra("time1",time1);
                intent1.putExtra("string2",string2);
                intent1.putExtra("time2",time2);
                intent1.putExtra("string3",string3);
                intent1.putExtra("time3",time3);
                startActivity(intent1);
        }
    }
}
