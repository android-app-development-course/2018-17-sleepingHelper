package com.example.asus.sleephelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context)
    {
        super(context,"itcast db",null,1);
    }
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE information(_id INTEGER PRIMARY KEY AUTOINCREMENT,betweentime INTEGER,sign INTEGER,year INTEGER,month INTEGER," +
                "date INTEGER,hour INTEGER,minute INTEGER)");
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {}
}
