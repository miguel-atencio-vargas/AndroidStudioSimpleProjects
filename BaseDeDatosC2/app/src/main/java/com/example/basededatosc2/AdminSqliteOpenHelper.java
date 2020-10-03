package com.example.basededatosc2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSqliteOpenHelper extends SQLiteOpenHelper {
    public AdminSqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }
    public void onCreate(SQLiteDatabase db){
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
