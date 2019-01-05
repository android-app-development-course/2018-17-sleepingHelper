package com.example.asus.sleephelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        final String[] urls={
                "https://mp.weixin.qq.com/s?__biz=MzAxNjU3MjMzOQ==&mid=504115715&idx=1&sn=01b86c783dd71f6a117d6c9f2636d425&chksm=000a58df377dd1c93c0ccd1514c7c1d0926a487f03e1483bf56e427ec1fc05831be9f5c8f847#rd",
                "https://mp.weixin.qq.com/s?__biz=MzAxNjU3MjMzOQ==&mid=504115711&idx=1&sn=cc6c06e097bfac5a9922eead276fd9f5&chksm=000a5b23377dd235f38f1bd58cd4cf0ce4b3095c42ebed632c58aa7bbbab4aa3edf3b1e9ae65#rd",
                "https://mp.weixin.qq.com/s?__biz=MzAxNjU3MjMzOQ==&mid=504115707&idx=1&sn=e0955eae2a7af1cdedd66b68ab8bd432&chksm=000a5b27377dd2318296ba272d4533ddaa7fd407660472f7c8edb46043c9bbcdea2b3e409cdf#rd",
                "https://mp.weixin.qq.com/s?__biz=MzAxNjU3MjMzOQ==&mid=504115683&idx=1&sn=a4b81a7d7fd04313a7a2f893177499fb&chksm=000a5b3f377dd229b07e046d41179023f886ab0c7e7a2c57b245cc73ea484484bf61ae302538#rd",
                "https://mp.weixin.qq.com/s?__biz=MzAxNjU3MjMzOQ==&mid=504115680&idx=1&sn=4396b042cda1072d3f695e1e2a87bcba&chksm=000a5b3c377dd22a74635810871c4bd83ee6bdc6326fcb34a0d5fd8240b61752806607448530#rd"
        };
        //int[] ids={R.drawable.text2,R.drawable.text3,R.drawable.text4};
        ListView listView=(ListView)findViewById(R.id.MoreList);
        List<HashMap<String,Object>> mylist=new ArrayList<HashMap<String, Object>>();

        HashMap<String,Object> map2=new HashMap<String,Object>();
        map2.put("imageView",R.drawable.text2);
        mylist.add(map2);

        HashMap<String,Object> map3=new HashMap<String,Object>();
        map3.put("imageView",R.drawable.text3);
        mylist.add(map3);

        HashMap<String,Object> map4=new HashMap<String,Object>();
        map4.put("imageView",R.drawable.text4);
        mylist.add(map4);

        HashMap<String,Object> map5=new HashMap<String,Object>();
        map5.put("imageView",R.drawable.text5);
        mylist.add(map5);

        HashMap<String,Object> map6=new HashMap<String,Object>();
        map6.put("imageView",R.drawable.text6);
        mylist.add(map6);

        SimpleAdapter adapter=new SimpleAdapter(
                this,
                mylist,
                R.layout.list_items2,
                new String[]{"imageView"},
                new int[]{R.id.imageView});
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                webActivity.url=urls[arg2];
                Intent intent=new Intent(MoreActivity.this, webActivity.class);
                startActivity(intent);
            }
        });

    }

}
