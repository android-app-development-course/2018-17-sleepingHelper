package com.example.asus.sleephelper.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.example.asus.sleephelper.Fragment.RoutineFragment;
import com.example.asus.sleephelper.Fragment.SleephelpFragment;
import com.example.asus.sleephelper.Fragment.reportFragment;
import com.example.asus.sleephelper.Fragment.sounceFragment;
import com.example.asus.sleephelper.R;
import com.example.asus.sleephelper.adapter.PagerMainAdapter;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends BActivity {

    private ViewPager vp;
    private RadioGroup rg;
    private int[] rbs = {R.id.sound, R.id.sleepHelp, R.id.routine,R.id.report};
    private List<Fragment> mFragments;
    //简化后的方法
    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }
    @Override
    protected void initView() {
        vp = f(R.id.vp);
        rg = f(R.id.rg);
    }
    @Override
    protected void initData() {
        mFragments = new ArrayList<>();
        sounceFragment one=new sounceFragment();
        SleephelpFragment two=new SleephelpFragment();
        RoutineFragment three=new RoutineFragment();
        reportFragment four=new reportFragment();
        mFragments.add(one);
        mFragments.add(two);
        mFragments.add(three);
        mFragments.add(four);
        // 设置填充器
        vp.setAdapter(new PagerMainAdapter(getSupportFragmentManager(), mFragments));
        // 设置缓存页面数
        vp.setOffscreenPageLimit(4);
    }

    protected void initListener() {
        //radioGroup的点击事件
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                for (int i = 0; i < rbs.length; i++) {
                    if (rbs[i] != checkedId) continue;
                    //加载滑动
                    vp.setCurrentItem(i);
                }
            }
        });
        //ViewPager的点击事件 vp-rg互相监听：vp
        vp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                rg.check(rbs[position]);
            }
        });
        //设置一个默认页
        rg.check(rbs[0]);
    }
}




