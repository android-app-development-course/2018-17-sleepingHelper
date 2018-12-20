package com.example.asus.sleephelper;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class mydialog1 extends Dialog {
    private String dialogtext;
    private String dialogtitle;
    private int showphoto;
    private ImageView photo;
    private TextView tvMsg;
    private TextView tvTitle;
    public mydialog1(Context context, String dialogtext,String dialogtitle, int photo)
    {
        super(context);
        this.dialogtext=dialogtext;
        this.showphoto=photo;
        this.dialogtitle=dialogtitle;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去标题
       setContentView(R.layout.my_dialog1);
       tvMsg=(TextView)findViewById(R.id.tv_msg);
        tvTitle=(TextView)findViewById(R.id.tv_title);
       photo=(ImageView)findViewById(R.id.showphoto);
       photo.setImageResource(showphoto);
       tvMsg.setText(dialogtext);
       tvTitle.setText(dialogtitle);
    }

}
