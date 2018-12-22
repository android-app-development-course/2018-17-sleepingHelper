package com.example.asus.sleephelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class evaluateactivity extends AppCompatActivity {
    private Button tijiao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluateactivity);
        tijiao=(Button)findViewById(R.id.tijiao);
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(evaluateactivity.this,"感谢你的评价!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
