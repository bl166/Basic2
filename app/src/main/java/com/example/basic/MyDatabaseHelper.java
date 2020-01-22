package com.example.basic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Mohanselva_2";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CREATE = "";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        //database.execSQL(TABLE_CREATE);
    }

    @Override
    public void onOpen(SQLiteDatabase database) {

    }




    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion){
        // do whatever is required for the upgrade
    }
}