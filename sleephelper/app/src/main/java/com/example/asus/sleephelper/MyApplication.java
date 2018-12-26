package com.example.asus.sleephelper;

import android.app.Application;

public class MyApplication extends Application{
        private int all_flag=1;
        private int hourone=0;
        private int minuteone=0;
        private int hourtwo=0;
        private int hourthree=0;
        private int minutetwo=0;
        private int minutethree=0;
        private boolean isload=false;
        public int getAll_flag() {
        return this.all_flag;
        }
        public void setAll_flag(int flag) {this.all_flag=flag;}
        public int getHourone(){return this.hourone;}
        public int getHourtwo(){return this.hourtwo;}
        public int getHourthree(){return this.hourthree;}
        public void setHourone(int hour){this.hourone=hour;}
        public void setHourtwo(int hour){this.hourtwo=hour;}
        public void setHourthree(int hour){this.hourthree=hour;}
        public int getMinuteone(){return this.minuteone;}
        public int getMinutetwo(){return this.minutetwo;}
        public int getMinutethree(){return this.minutethree;}
        public void setMinuteone(int minute){this.minuteone=minute;}
        public void setMinutetwo(int minute){this.minutetwo=minute;}
        public void setMinutethree(int minute){this.minutethree=minute;}
        public void setIsload(boolean set) {this.isload=set;}
        public boolean getIsload(){return isload;}
}
