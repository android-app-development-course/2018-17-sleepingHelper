package com.example.asus.sleephelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context)
    {
        super(context,"itcast.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE  TABLE IF NOT EXISTS information(_id INTEGER PRIMARY KEY AUTOINCREMENT,betweentime INTEGER,year INTEGER,month INTEGER,date INTEGER,hour INTEGER,minute INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS numberpassword(_id INTEGER PRIMARY KEY AUTOINCREMENT,number VARCHAR(20),password VARCHAR(20))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
