package com.example.asus.sleephelper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.example.asus.sleephelper.Fragment.reportFragment;
import com.example.asus.sleephelper.R;

public abstract class BActivity extends FragmentActivity {
    protected BActivity act;
    protected final String TAG=getClass().getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act=this;
        setContentView(getLayoutID());
        initView();
        initData();
        initListener();
    }
    @LayoutRes
    protected abstract int getLayoutID();
    protected abstract void initListener();
    protected abstract void initView();
    protected abstract void initData();
    @SuppressWarnings("unchecked")
    protected <E> E f(int id) {
        return (E) findViewById(id);
    }
}
