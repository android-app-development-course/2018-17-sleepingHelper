package com.example.asus.sleephelper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loadactivity extends AppCompatActivity {
    private Button load;
    private TextView applynumber;
    private EditText et_number;
    private EditText et_password;
    MyHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadactivity);
        myHelper=new MyHelper(this);
        load=(Button)findViewById(R.id.btn_login);
        applynumber=(TextView)findViewById(R.id.applynumber);
        et_number=(EditText)findViewById(R.id.et_number);
        et_password=(EditText)findViewById(R.id.et_password);
        applynumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loadactivity.this,applynumberactivity.class);
                startActivity(intent);
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=et_number.getText().toString();
                String s2=et_password.getText().toString();
                if(!s1.equals("")&&!s2.equals("")) {
                    SQLiteDatabase db;
                    db=myHelper.getReadableDatabase();
                    Cursor cursor=db.query("numberpassword",null,"number=? and password=?",new String[]{s1,s2},null,null,null);
                    if(cursor.getCount()==0) {
                        cursor.close();
                        db.close();
                        Toast.makeText(loadactivity.this,"账号密码错误",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        cursor.close();
                        db.close();
                        Toast.makeText(loadactivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        MyApplication application = (MyApplication)loadactivity.this.getApplication();
                        application.setIsload(true);
                        MainActivity.username.setText(s1);
                        finish();
                    }
                }
                else Toast.makeText(loadactivity.this,"请输入账号密码",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
