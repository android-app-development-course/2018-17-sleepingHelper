package com.example.asus.sleephelper;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private List<Fragment> fragmentList=new ArrayList<>();
    private NavigationView navigationView ;
    private View headerLayout;
    private CircleImageView headphoto;
    public static TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.vp);
        radioGroup=(RadioGroup)findViewById(R.id.rg);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        headerLayout = navigationView.getHeaderView(0);
        headphoto=(CircleImageView)headerLayout.findViewById(R.id.head_photo);
        username=(TextView) headerLayout.findViewById(R.id.username);

        soundFragment sFragment=new soundFragment();
        SleepHelpFragment sleepHelpFragment=new SleepHelpFragment();
        RoutineFragment routineFragment=new RoutineFragment();
        reportFragment rpFragment=new reportFragment();

        fragmentList.add(sFragment);
        fragmentList.add(sleepHelpFragment);
        fragmentList.add(routineFragment);
        fragmentList.add(rpFragment);

        viewPager.setAdapter(new PagerMainAdapter(getSupportFragmentManager(),fragmentList));

        // ViewPager页面切换监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radioGroup.check(R.id.sound);
                        break;
                    case 1:
                        radioGroup.check(R.id.sleepHelp);
                        break;
                    case 2:
                        radioGroup.check(R.id.routine);
                        break;
                    case 3:
                        radioGroup.check(R.id.report);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // RadioGroup选中状态改变监听
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.sound:
                        /**
                         * setCurrentItem第二个参数控制页面切换动画
                         * true:打开/false:关闭
                         */
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.sleepHelp:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.routine:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.report:
                        viewPager.setCurrentItem(3);
                        break;
                    default:
                        break;
                }
            }
        });
        setNavItemListener();
    }
    public void setNavItemListener() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //在这里处理item的点击事件
                // item.setChecked(true);
                //item.getItemId()
                switch (item.getItemId()) {
                    case R.id.discover:
                        Intent intent=new Intent(MainActivity.this,discoveractivity.class);
                        startActivity(intent);
                        break;
                    case R.id.about_us:
                        Intent intent1=new Intent(MainActivity.this,aboutusactivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.help:
                        Intent intent2=new Intent(MainActivity.this,helpactivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.evaluate:
                        Intent intent3=new Intent(MainActivity.this,evaluateactivity.class);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });
        headphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication application = (MyApplication)MainActivity.this.getApplication();
                if(!application.getIsload()) {
                    Intent intent=new Intent(MainActivity.this,loadactivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"已经处于登录状态",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}






