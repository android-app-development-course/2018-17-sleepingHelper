package com.example.asus.sleephelper;

import android.app.Application;

public class MyApplication extends Application{
        private int id=1;
        private int top1=0;
        private int top2=50;
        public int getId() {
        return id;
        }
        public void setId(int Id){
            this.id=Id;
        }
        public int getTop1() { return top1;}
        public int getTop2() { return top2;}
        public void setTop1(int top){this.top1=top;}
        public void setTop2(int top){this.top2=top;}
}
