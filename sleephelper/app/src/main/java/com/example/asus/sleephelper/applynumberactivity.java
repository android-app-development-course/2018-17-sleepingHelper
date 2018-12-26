package com.example.asus.sleephelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class applynumberactivity extends AppCompatActivity {
    private Button applysure;
    private EditText et_inputnumber;
    private EditText et_inputpassword;
    MyHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applynumberactivity);
        applysure=(Button)findViewById(R.id.applysure);
        et_inputnumber=(EditText)findViewById(R.id.et_inputnumber);
        et_inputpassword=(EditText)findViewById(R.id.et_inputpassword);
        myHelper=new MyHelper(this);
        applysure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=et_inputnumber.getText().toString();
                String s2=et_inputpassword.getText().toString();
                if(!s1.equals("")&&!s2.equals("")) {
                    if(s1.length()>20||s2.length()>20){
                        Toast.makeText(applynumberactivity.this,"账户密码不能超过20个字符哦",Toast.LENGTH_SHORT).show();
                    } else{
                        SQLiteDatabase db;
                        db=myHelper.getReadableDatabase();
                        Cursor cursor=db.query("numberpassword",null,"number=?",new String[]{s1},null,null,null);
                        if(cursor.getCount()==0) {
                            cursor.close();
                            db.close();
                            ContentValues values;
                            db=myHelper.getWritableDatabase();
                            values=new ContentValues();
                            values.put("number",s1);
                            values.put("password",s2);
                            db.insert("numberpassword",null,values);
                            Toast.makeText(applynumberactivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                            db.close();
                            finish();
                        }
                        else {
                            cursor.close();
                            db.close();
                            Toast.makeText(applynumberactivity.this,"账户已存在",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else Toast.makeText(applynumberactivity.this,"账户密码不能为空哦",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
