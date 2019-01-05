package com.example.asus.sleephelper;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class soundFragment extends Fragment{
    private Button More;
    private ImageButton imageButton1_1;
//    private ImageButton imageButton1_2;
//    private ImageButton imageButton1_3;
//    private ImageButton imageButton1_4;

    private ImageButton imageButton2_1;
    private ImageButton imageButton2_2;
    private ImageButton imageButton2_3;
    private ImageButton imageButton2_4;

    private ViewPager viewPager;
    private ArrayList<View> pageview;
    Handler handler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sound,null);
        More=(Button)view.findViewById(R.id.More) ;
        imageButton1_1=(ImageButton)view.findViewById(R.id.imageButton1_1);
        imageButton2_1=(ImageButton)view.findViewById(R.id.imageButton2_1);
        imageButton2_2=(ImageButton)view.findViewById(R.id.imageButton2_2);
        imageButton2_3=(ImageButton)view.findViewById(R.id.imageButton2_3);
        imageButton2_4=(ImageButton)view.findViewById(R.id.imageButton2_4);

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);

        View page1=inflater.inflate(R.layout.page3,null);
        View page2=inflater.inflate(R.layout.page4,null);
        View page3=inflater.inflate(R.layout.page1,null);
        View page4=inflater.inflate(R.layout.page2,null);

        pageview=new ArrayList<View>();
        pageview.add(page1);
        pageview.add(page2);
        pageview.add(page3);
        pageview.add(page4);

        PagerAdapter mPagerAdapter = new PagerAdapter(){
            @Override
            //获取当前窗体界面数
            public int getCount() {
                // TODO Auto-generated method stub
                //return pageview.size();
                return 10000;
            }
            @Override
            //断是否由对象生成界面
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0==arg1;
            }
            //是从ViewGroup中移出当前View
            public void destroyItem(View arg0, int arg1, Object arg2) {
                // ((ViewPager) arg0).removeView(pageview.get(arg1));
            }

            //返回一个对象，这个对象表明了PagerAdapter适配器选择哪个对象放在当前的ViewPager中
            public Object instantiateItem(View arg0, int arg1){
                try {
                    ((ViewPager) arg0).addView(pageview.get(arg1%pageview.size()));
                }catch (Exception e) {

                }
                return pageview.get(arg1%pageview.size());
            }
        };
        viewPager.setAdapter(mPagerAdapter);
        handler=new Handler();
        handler.postDelayed(new TimerRunnable(),10000);
        return view;
    }

    class TimerRunnable implements Runnable{

        @Override
        public void run() {
            int curItem = viewPager.getCurrentItem();
            viewPager.setCurrentItem(curItem+1);
            if (handler!=null){
                handler.postDelayed(this,10000);
            }
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        More.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MoreActivity.class);
                getActivity().startActivity(intent);
            }
        });

        imageButton1_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                webActivity.url="https://www.psy-1.com/mob/home/wenjuan/46";
                Intent intent=new Intent(getActivity(), webActivity.class);
                getActivity().startActivity(intent);
            }
        });

        imageButton2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), MusicShowActivity.class);
                it.putExtra("num",0);
                getActivity().startActivity(it);
            }
        });

        imageButton2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), MusicShowActivity.class);
                it.putExtra("num",1);
                getActivity().startActivity(it);
            }
        });

        imageButton2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), MusicShowActivity.class);
                it.putExtra("num",2);
                getActivity().startActivity(it);
            }
        });

        imageButton2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), MusicShowActivity.class);
                it.putExtra("num",3);
                getActivity().startActivity(it);
            }
        });
    }

    public void onDestroy()
    {
        super.onDestroy();
        handler = null;
    }

}
