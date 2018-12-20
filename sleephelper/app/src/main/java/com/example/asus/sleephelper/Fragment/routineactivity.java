package com.example.asus.sleephelper.Fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.sleephelper.R;
import com.example.asus.sleephelper.beforesleepactivity;
import com.example.asus.sleephelper.mydialog1;

public class routineactivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private ImageView iv5;
    private ImageView iv6;
    private ImageView iv7;
    private ImageView iv8;
    private ImageView iv9;
    private ImageView iv10;
    private ImageView iv11;
    private ImageView iv12;
    private ImageView iv13;
    private ImageView iv14;
    private ImageView iv15;
    private CheckBox select1;
    private CheckBox select2;
    private CheckBox select3;
    private CheckBox select4;
    private CheckBox select5;
    private CheckBox select6;
    private CheckBox select7;
    private CheckBox select8;
    private CheckBox select9;
    private CheckBox select10;
    private CheckBox select11;
    private CheckBox select12;
    private CheckBox select13;
    private CheckBox select14;
    private CheckBox select15;
    private TextView selecttext1;
    private TextView selecttext2;
    private TextView selecttext3;
    private TextView selecttext4;
    private TextView selecttext5;
    private TextView selecttext6;
    private TextView selecttext7;
    private TextView selecttext8;
    private TextView selecttext9;
    private TextView selecttext10;
    private TextView selecttext11;
    private TextView selecttext12;
    private TextView selecttext13;
    private TextView selecttext14;
    private TextView selecttext15;
    private TextView startrightnow;
    private int flag=0;
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
        setContentView(R.layout.activity_routineactivity);
        iv1=(ImageView)findViewById(R.id.beforesleepiv1);
        iv2=(ImageView)findViewById(R.id.beforesleepiv2);
        iv3=(ImageView)findViewById(R.id.beforesleepiv3);
        iv4=(ImageView)findViewById(R.id.beforesleepiv4);
        iv5=(ImageView)findViewById(R.id.beforesleepiv5);
        iv6=(ImageView)findViewById(R.id.beforesleepiv6);
        iv7=(ImageView)findViewById(R.id.beforesleepiv7);
        iv8=(ImageView)findViewById(R.id.beforesleepiv8);
        iv9=(ImageView)findViewById(R.id.beforesleepiv9);
        iv10=(ImageView)findViewById(R.id.beforesleepiv10);
        iv11=(ImageView)findViewById(R.id.beforesleepiv11);
        iv12=(ImageView)findViewById(R.id.beforesleepiv12);
        iv13=(ImageView)findViewById(R.id.beforesleepiv13);
        iv14=(ImageView)findViewById(R.id.beforesleepiv14);
        iv15=(ImageView)findViewById(R.id.beforesleepiv15);
        select1=(CheckBox)findViewById(R.id.select1);
        select2=(CheckBox)findViewById(R.id.select2);
        select3=(CheckBox)findViewById(R.id.select3);
        select4=(CheckBox)findViewById(R.id.select4);
        select5=(CheckBox)findViewById(R.id.select5);
        select6=(CheckBox)findViewById(R.id.select6);
        select7=(CheckBox)findViewById(R.id.select7);
        select8=(CheckBox)findViewById(R.id.select8);
        select9=(CheckBox)findViewById(R.id.select9);
        select10=(CheckBox)findViewById(R.id.select10);
        select11=(CheckBox)findViewById(R.id.select11);
        select12=(CheckBox)findViewById(R.id.select12);
        select13=(CheckBox)findViewById(R.id.select13);
        select14=(CheckBox)findViewById(R.id.select14);
        select15=(CheckBox)findViewById(R.id.select15);
        selecttext1=(TextView)findViewById(R.id.selecttext1);
        selecttext2=(TextView)findViewById(R.id.selecttext2);
        selecttext3=(TextView)findViewById(R.id.selecttext3);
        selecttext4=(TextView)findViewById(R.id.selecttext4);
        selecttext5=(TextView)findViewById(R.id.selecttext5);
        selecttext6=(TextView)findViewById(R.id.selecttext6);
        selecttext7=(TextView)findViewById(R.id.selecttext7);
        selecttext8=(TextView)findViewById(R.id.selecttext8);
        selecttext9=(TextView)findViewById(R.id.selecttext9);
        selecttext10=(TextView)findViewById(R.id.selecttext10);
        selecttext11=(TextView)findViewById(R.id.selecttext11);
        selecttext12=(TextView)findViewById(R.id.selecttext12);
        selecttext13=(TextView)findViewById(R.id.selecttext13);
        selecttext14=(TextView)findViewById(R.id.selecttext14);
        selecttext15=(TextView)findViewById(R.id.selecttext15);
        startrightnow=(TextView)findViewById(R.id.startrightnow);

        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
        iv3.setOnClickListener(this);
        iv4.setOnClickListener(this);
        iv5.setOnClickListener(this);
        iv6.setOnClickListener(this);
        iv7.setOnClickListener(this);
        iv8.setOnClickListener(this);
        iv9.setOnClickListener(this);
        iv10.setOnClickListener(this);
        iv11.setOnClickListener(this);
        iv12.setOnClickListener(this);
        iv13.setOnClickListener(this);
        iv14.setOnClickListener(this);
        iv15.setOnClickListener(this);
        select1.setOnClickListener(this);
        select2.setOnClickListener(this);
        select3.setOnClickListener(this);
        select4.setOnClickListener(this);
        select5.setOnClickListener(this);
        select6.setOnClickListener(this);
        select7.setOnClickListener(this);
        select8.setOnClickListener(this);
        select9.setOnClickListener(this);
        select10.setOnClickListener(this);
        select11.setOnClickListener(this);
        select12.setOnClickListener(this);
        select13.setOnClickListener(this);
        select14.setOnClickListener(this);
        select15.setOnClickListener(this);
        startrightnow.setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.beforesleepiv1:
                mydialog1 md1=new mydialog1(this,"缓解身体疲劳，形成仪式感，建议为睡前首个步骤，以为洗澡后往往" +
                        "体温过高不宜睡眠，所以流出时间让身体顺应昼夜节奏调低体温，酝酿睡意","睡前洗漱",R.drawable.brush);
                md1.show();
                break;
            case R.id.beforesleepiv2:
                mydialog1 md2=new mydialog1(this,"把第二天的事情列出清单，准备好必须品，也可以提前做一些简单、和缓" +
                        "的准备工作，这样可以避免睡前让琐碎小事塞满大脑，彻底地放空自己","整理行程",R.drawable.brush);
                md2.show();
                break;
            case R.id.beforesleepiv3:
                mydialog1 md3=new mydialog1(this,"根据自己的习惯对环境略加整理：扫地，整理书桌或抽屉、收拾散落的衣服等，" +
                        "让物件们各得其所，既优化生活环境，又放慢情绪，安心入眠","整理环境",R.drawable.brush);
                md3.show();
                break;
            case R.id.beforesleepiv4:
                mydialog1 md4=new mydialog1(this,"在睡眠过程中发生的离线记忆再处理过程是记忆形成机制中非常重要的组成部分。" +
                        "根据你自己的喜好记忆少量单词/练字/复习/今天所习得的技能等等，利用睡眠巩固记忆" ,"轻度学习",R.drawable.brush);
                md4.show();
                break;
            case R.id.beforesleepiv5:
                mydialog1 md5=new mydialog1(this,"双手手指弯曲按摩头皮，方向为前发际-头顶-后部-项部，左中右三行，每次至少五分钟" +
                        "。也可用梳子梳头，方法同前，梳齿不宜过尖，过密","按摩头部",R.drawable.brush);
                md5.show();
                break;
            case R.id.beforesleepiv6:
                mydialog1 md6=new mydialog1(this,"每日临睡前取仰卧位，微屈小腿，以两足心紧贴床面，做上下摩擦动作。还可配合" +
                        "热水泡脚来加强效果，以微微出汗微妙，睡前注意擦干保暖","搓涌泉穴",R.drawable.brush);
                md6.show();
                break;
            case R.id.beforesleepiv7:
                mydialog1 md7=new mydialog1(this,"仰卧床上，意守丹田，先用右手顺时针方向绕肚脐稍加用力揉腹，一边揉一边默念计数，" +
                        "揉记120次。再换左手逆时针方向绕肚脐揉120次","仰卧揉腹",R.drawable.brush);
                md7.show();
                break;
            case R.id.beforesleepiv8:
                mydialog1 md8=new mydialog1(this,"非常有效的睡前呼吸大法，是天然的镇定剂，建议作为睡前准备的最后环节，步骤为：" +
                        "鼻子吸气4秒-屏气7秒-嘴巴呼气8秒（呼气时请发出“呼”声）；正腹式：吸气时腹部隆起，呼气时腹部凹下","478促眠大法",R.drawable.brush);
                md8.show();
                break;
            case R.id.beforesleepiv9:
                mydialog1 md9=new mydialog1(this,"增加氧气，缓解压力，预防心肺问题，缓解躯体紧张，帮助大脑放松，建议作为睡前准备最后" +
                        "环节，步骤为：鼻子吸气5秒-鼻子呼气5秒；正腹式：吸气时腹部隆起，呼气时腹部凹下","均等放松呼吸",R.drawable.brush);
                md9.show();
                break;
            case R.id.beforesleepiv10:
                mydialog1 md10=new mydialog1(this,"平心静气，内观自我，让身心休息，滋生能量，清理负面情绪，建议作为睡前" +
                        "最后环节，步骤为：鼻子吸气5秒-屏气5秒-鼻子呼气10秒；正腹式：吸气时腹部隆起，呼气时腹部凹下","冥想禅修呼吸",R.drawable.brush);
                md10.show();
                break;
            case R.id.beforesleepiv11:
                mydialog1 md11=new mydialog1(this,"拿出纸笔，把当天的所有想法、担心和关心都写下来，也可以轻松地涂涂画画，" +
                        "这样可以把情绪清零，减少忧思杂念，保持平静的情绪进入睡眠","下载你的一天",R.drawable.brush);
                md11.show();
                break;
            case R.id.beforesleepiv12:
                mydialog1 md12=new mydialog1(this,"该选项代表你自己特有的睡前准备习惯，无论他是什么，只要是可以帮助你顺利" +
                        "入眠，行成睡觉前的某种固定习惯和形式感的，都可以考虑","个人特有习惯",R.drawable.brush);
                md12.show();
                break;
            case R.id.beforesleepiv13:
                mydialog1 md13=new mydialog1(this,"积精固本，帮助腰腹脏器活化，改善器官虚衰，功能混乱，建议饭后一小时进行" +
                        "，步骤为：鼻子吸气5秒-屏气2秒-鼻子呼气8秒；逆腹式：吸气时腹部凹下，呼气时腹部鼓起（年老体虚及高血压患者、各类心脏病患者及孕妇慎用或禁用）","固本培元法",R.drawable.brush);
                md13.show();
                break;
            case R.id.beforesleepiv14:
                mydialog1 md14=new mydialog1(this,"充分调动人体机能，提高基础代谢率，在畅快的一呼一吸中减少多于的脂肪" +
                        "。建议饭前或饭后两小时进行，步骤为：鼻子吸气6秒-屏气2秒-鼻子呼气6秒；正腹式：吸气时腹部隆起，呼气时腹部凹下","瘦身减腹呼吸",R.drawable.brush);
                md14.show();
                break;
            case R.id.beforesleepiv15:
                mydialog1 md15=new mydialog1(this,"改善肠胃功能，促进体内毒素排出，护肤养颜。建议饭后一小时进行，步骤为：鼻子吸气5秒-屏气" +
                        "2秒-鼻子呼气5秒；逆腹式：吸气时腹部凹下，呼气时腹部鼓起（年老体虚及高血压患者、各类心脏病患者及孕妇慎用或禁用）","养胃美颜呼吸",R.drawable.brush);
                md15.show();
                break;
            case R.id.select1:
                if(select1.isChecked()) flag=flag+1;
                else if(!select1.isChecked())
                {
                    flag=flag-1;
                    selecttext1.setText("");
                    selecttext1.setEnabled(false);
                    selecttext1.setHint("min");
                }
                if(flag>3)
                {
                    select1.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select1.isChecked()) selecttext1.setEnabled(true);
                break;
            case R.id.select2:
                if(select2.isChecked()) flag=flag+1;
                else if(!select2.isChecked())
                {
                    flag=flag-1;
                    selecttext2.setText("");
                    selecttext2.setEnabled(false);
                    selecttext2.setHint("min");
                }
                if(flag>3)
                {
                    select2.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select2.isChecked()) selecttext2.setEnabled(true);
                break;
            case R.id.select3:
                if(select3.isChecked()) flag=flag+1;
                else if(!select3.isChecked())
                {
                    flag=flag-1;
                    selecttext3.setText("");
                    selecttext3.setEnabled(false);
                    selecttext3.setHint("min");
                }
                if(flag>3)
                {
                    select3.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select3.isChecked()) selecttext3.setEnabled(true);
                break;
            case R.id.select4:
                if(select4.isChecked()) flag=flag+1;
                else if(!select4.isChecked())
                {
                    flag=flag-1;
                    selecttext4.setText("");
                    selecttext4.setEnabled(false);
                    selecttext4.setHint("min");
                }
                if(flag>3)
                {
                    select4.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select4.isChecked()) selecttext4.setEnabled(true);
                break;
            case R.id.select5:
                if(select5.isChecked()) flag=flag+1;
                else if(!select5.isChecked())
                {
                    flag=flag-1;
                    selecttext5.setText("");
                    selecttext5.setEnabled(false);
                    selecttext5.setHint("min");
                }
                if(flag>3)
                {
                    select15.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select5.isChecked()) selecttext5.setEnabled(true);
                break;
            case R.id.select6:
                if(select6.isChecked()) flag=flag+1;
                else if(!select6.isChecked())
                {
                    flag=flag-1;
                    selecttext6.setText("");
                    selecttext6.setEnabled(false);
                    selecttext6.setHint("min");
                }
                if(flag>3)
                {
                    select6.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select6.isChecked()) selecttext6.setEnabled(true);
                break;
            case R.id.select7:
                if(select7.isChecked()) flag=flag+1;
                else if(!select7.isChecked())
                {
                    flag=flag-1;
                    selecttext7.setText("");
                    selecttext7.setEnabled(false);
                    selecttext7.setHint("min");
                }
                if(flag>3)
                {
                    select7.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select7.isChecked()) selecttext7.setEnabled(true);
                break;
            case R.id.select8:
                if(select8.isChecked()) flag=flag+1;
                else if(!select8.isChecked())
                {
                    flag=flag-1;
                    selecttext8.setText("");
                    selecttext8.setEnabled(false);
                    selecttext8.setHint("min");
                }
                if(flag>3)
                {
                    select8.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select8.isChecked()) selecttext8.setEnabled(true);
                break;
            case R.id.select9:
                if(select9.isChecked()) flag=flag+1;
                else if(!select9.isChecked())
                {
                    flag=flag-1;
                    selecttext9.setText("");
                    selecttext9.setEnabled(false);
                    selecttext9.setHint("min");
                }
                if(flag>3)
                {
                    select9.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select9.isChecked()) selecttext9.setEnabled(true);
                break;
            case R.id.select10:
                if(select10.isChecked()) flag=flag+1;
                else if(!select10.isChecked())
                {
                    flag=flag-1;
                    selecttext10.setText("");
                    selecttext10.setEnabled(false);
                    selecttext10.setHint("min");
                }
                if(flag>3)
                {
                    select10.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select10.isChecked()) selecttext10.setEnabled(true);
                break;
            case R.id.select11:
                if(select11.isChecked()) flag=flag+1;
                else if(!select11.isChecked())
                {
                    flag=flag-1;
                    selecttext11.setText("");
                    selecttext11.setEnabled(false);
                    selecttext11.setHint("min");
                }
                if(flag>3)
                {
                    select11.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select11.isChecked()) selecttext11.setEnabled(true);
                break;
            case R.id.select12:
                if(select12.isChecked()) flag=flag+1;
                else if(!select12.isChecked())
                {
                    flag=flag-1;
                    selecttext12.setText("");
                    selecttext12.setEnabled(false);
                    selecttext12.setHint("min");
                }
                if(flag>3)
                {
                    select12.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select12.isChecked()) selecttext12.setEnabled(true);
                break;
            case R.id.select13:
                if(select13.isChecked()) flag=flag+1;
                else if(!select13.isChecked())
                {
                    flag=flag-1;
                    selecttext13.setText("");
                    selecttext13.setEnabled(false);
                    selecttext13.setHint("min");
                }
                if(flag>3)
                {
                    select13.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select13.isChecked()) selecttext13.setEnabled(true);
                break;
            case R.id.select14:
                if(select14.isChecked()) flag=flag+1;
                else if(!select14.isChecked())
                {
                    flag=flag-1;
                    selecttext14.setText("");
                    selecttext14.setEnabled(false);
                    selecttext14.setHint("min");
                }
                if(flag>3)
                {
                    select14.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select14.isChecked()) selecttext14.setEnabled(true);
                break;
            case R.id.select15:
                if(select15.isChecked()) flag=flag+1;
                else if(!select15.isChecked())
                {
                    flag=flag-1;
                    selecttext15.setText("");
                    selecttext15.setEnabled(false);
                    selecttext15.setHint("min");
                }
                if(flag>3)
                {
                    select15.setChecked(false);
                    flag=flag-1;
                    Toast.makeText(this,"只支持三个睡前运动哦",Toast.LENGTH_LONG).show();
                }
                else if(flag<=3&&select15.isChecked()) selecttext15.setEnabled(true);
                break;
            case R.id.startrightnow:
                if(select1.isChecked())
                {
                   if(string1=="NULL")
                   {
                       string1="睡前洗漱";
                       photo1=R.drawable.brushone;
                       time1=selecttext1.getText().toString();
                   }
                   else if(string2=="NULL")
                   {
                       {
                           string2="睡前洗漱";
                           photo2=R.drawable.brushone;
                           time2=selecttext1.getText().toString();
                       }
                   }
                   else if(string3=="NULL")
                   {
                       string3="睡前洗漱";
                       photo3=R.drawable.brushone;
                       time3=selecttext1.getText().toString();
                   }
                }
                if(select2.isChecked())
                {
                    if(string1=="NULL")
                    {
                        string1="整理行程";
                        photo1=R.drawable.xingcheng;
                        time1=selecttext2.getText().toString();
                    }
                    else if(string2=="NULL")
                    {
                        {
                            string2="整理行程";
                            photo2=R.drawable.xingcheng;
                            time2=selecttext2.getText().toString();
                        }
                    }
                    else if(string3=="NULL")
                    {
                        string3="整理行程";
                        photo3=R.drawable.xingcheng;
                        time3=selecttext2.getText().toString();
                    }
                }
                if(select3.isChecked())
                {
                    if(string1=="NULL")
                    {
                        string1="整理环境";
                        photo1=R.drawable.clean;
                        time1=selecttext3.getText().toString();
                    }
                    else if(string2=="NULL")
                    {
                        {
                            string2="整理环境";
                            photo2=R.drawable.clean;
                            time2=selecttext3.getText().toString();
                        }
                    }
                    else if(string3=="NULL")
                    {
                        string3="整理环境";
                        photo3=R.drawable.clean;
                        time3=selecttext3.getText().toString();
                    }
                }
                if(select4.isChecked())
                {
                    if(string1=="NULL")
                    {
                        string1="轻度学习";
                        photo1=R.drawable.lightsleep;
                        time1=selecttext4.getText().toString();
                    }
                    else if(string2=="NULL")
                    {
                        {
                            string2="轻度学习";
                            photo2=R.drawable.lightsleep;
                            time2=selecttext4.getText().toString();
                        }
                    }
                    else if(string3=="NULL")
                    {
                        string3="轻度学习";
                        photo3=R.drawable.lightsleep;
                        time3=selecttext4.getText().toString();
                    }
                }
                if(select5.isChecked())
                {
                    if(string1=="NULL")
                    {
                        string1="按摩头部";
                        photo1=R.drawable.hair;
                        time1=selecttext5.getText().toString();
                    }
                    else if(string2=="NULL")
                    {
                        {
                            string2="按摩头部";
                            photo2=R.drawable.hair;
                            time2=selecttext5.getText().toString();
                        }
                    }
                    else if(string3=="NULL")
                    {
                        string3="按摩头部";
                        photo3=R.drawable.hair;
                        time3=selecttext5.getText().toString();
                    }
                }
                if(select6.isChecked())
                {
                    if(string1=="NULL")
                    {
                        string1="搓涌泉穴";
                        photo1=R.drawable.foot;
                        time1=selecttext6.getText().toString();
                    }
                    else if(string2=="NULL")
                    {
                        {
                            string2="搓涌泉穴";
                            photo2=R.drawable.foot;
                            time2=selecttext6.getText().toString();
                        }
                    }
                    else if(string3=="NULL")
                    {
                        string3="搓涌泉穴";
                        photo3=R.drawable.foot;
                        time3=selecttext6.getText().toString();
                    }
                }
                if(select7.isChecked())
                {
                    if(string1=="NULL")
                    {
                        string1="仰卧揉腹";
                        photo1=R.drawable.kuanyao;
                        time1=selecttext7.getText().toString();
                    }
                    else if(string2=="NULL")
                    {
                        {
                            string2="仰卧揉腹";
                            photo2=R.drawable.kuanyao;
                            time2=selecttext7.getText().toString();
                        }
                    }
                    else if(string3=="NULL")
                    {
                        string3="仰卧揉腹";
                        photo3=R.drawable.kuanyao;
                        time3=selecttext7.getText().toString();
                    }
                }
                if(select8.isChecked())
                {
                    if(string1=="NULL")
                    {
                        string1="478促眠大法";
                        photo1=R.drawable.moonone;
                        time1=selecttext8.getText().toString();
                    }
                    else if(string2=="NULL")
                    {
                        {
                            string2="478促眠大法";
                            photo2=R.drawable.moonone;
                            time2=selecttext8.getText().toString();
                        }
                    }
                    else if(string3=="NULL")
                    {
                        string3="478促眠大法";
                        photo3=R.drawable.moonone;
                        time3=selecttext8.getText().toString();
                    }
                }
                if(select9.isChecked())
                {
                    if(string1=="NULL")
                    {
                        string1="均等放松呼吸";
                        photo1=R.drawable.flowerone;
                        time1=selecttext9.getText().toString();
                    }
                    else if(string2=="NULL")
                    {
                        {
                            string2="均等放松呼吸";
                            photo2=R.drawable.flowerone;
                            time2=selecttext9.getText().toString();
                        }
                    }
                    else if(string3=="NULL")
                    {
                        string3="均等放松呼吸";
                        photo3=R.drawable.flowerone;
                        time3=selecttext9.getText().toString();
                    }
                }
                if(select10.isChecked())
                {
                    if(string1=="NULL")
                    {
                        string1="冥想禅修呼吸";
                        photo1=R.drawable.flowertwo;
                        time1=selecttext10.getText().toString();
                    }
                    else if(string2=="NULL")
                    {
                        {
                            string2="冥想禅修呼吸";
                            photo2=R.drawable.flowertwo;
                            time2=selecttext10.getText().toString();
                        }
                    }
                    else if(string3=="NULL")
                    {
                        string3="冥想禅修呼吸";
                        photo3=R.drawable.flowertwo;
                        time3=selecttext10.getText().toString();
                    }
                }
                if(select11.isChecked())
                {
                    if(string1=="NULL")
                    {
                        string1="下载你的一天";
                        photo1=R.drawable.tounao;
                        time1=selecttext11.getText().toString();
                    }
                    else if(string2=="NULL")
                    {
                        {
                            string2="下载你的一天";
                            photo2=R.drawable.tounao;
                            time2=selecttext11.getText().toString();
                        }
                    }
                    else if(string3=="NULL")
                    {
                        string3="下载你的一天";
                        photo3=R.drawable.tounao;
                        time3=selecttext11.getText().toString();
                    }
                }
                if(select12.isChecked())
            {
                if(string1=="NULL")
                {
                    string1="个人特有习惯";
                    photo1=R.drawable.person;
                    time1=selecttext12.getText().toString();
                }
                else if(string2=="NULL")
                {
                    {
                        string2="个人特有习惯";
                        photo2=R.drawable.person;
                        time2=selecttext12.getText().toString();
                    }
                }
                else if(string3=="NULL")
                {
                    string3="个人特有习惯";
                    photo3=R.drawable.person;
                    time3=selecttext12.getText().toString();
                }
            }
                if(select13.isChecked())
                {
                    if(string1=="NULL")
                    {
                        string1="固本培元呼吸";
                        photo1=R.drawable.shan;
                        time1=selecttext13.getText().toString();
                    }
                    else if(string2=="NULL")
                    {
                        {
                            string2="固本培元呼吸";
                            photo2=R.drawable.shan;
                            time2=selecttext13.getText().toString();
                        }
                    }
                    else if(string3=="NULL")
                    {
                        string3="固本培元呼吸";
                        photo3=R.drawable.shan;
                        time3=selecttext13.getText().toString();
                    }
                }
                if(select14.isChecked())
                {
                    if(string1=="NULL")
                    {
                        string1="瘦身减腹呼吸";
                        photo1=R.drawable.hudie;
                        time1=selecttext14.getText().toString();
                    }
                    else if(string2=="NULL")
                    {
                        {
                            string2="瘦身减腹呼吸";
                            photo2=R.drawable.hudie;
                            time2=selecttext14.getText().toString();
                        }
                    }
                    else if(string3=="NULL")
                    {
                        string3="瘦身减腹呼吸";
                        photo3=R.drawable.hudie;
                        time3=selecttext14.getText().toString();
                    }
                }
                if(select15.isChecked())
                {
                    if(string1=="NULL")
                    {
                        string1="养胃美颜呼吸";
                        photo1=R.drawable.stomach;
                        time1=selecttext15.getText().toString();
                    }
                    else if(string2=="NULL")
                    {
                        {
                            string2="养胃美颜呼吸";
                            photo2=R.drawable.stomach;
                            time2=selecttext15.getText().toString();
                        }
                    }
                    else if(string3=="NULL")
                    {
                        string3="养胃美颜呼吸";
                        photo3=R.drawable.stomach;
                        time3=selecttext15.getText().toString();
                    }
                }
                Intent intent =new Intent(this,beforesleepactivity.class);
                    intent.putExtra("string1",string1);
                    intent.putExtra("time1",time1);
                    intent.putExtra("photo1",photo1);
                    intent.putExtra("string2",string2);
                    intent.putExtra("time2",time2);
                    intent.putExtra("photo2",photo2);
                    intent.putExtra("string3",string3);
                    intent.putExtra("time3",time3);
                    intent.putExtra("photo3",photo3);
                startActivity(intent);
        }
    }

}
