package com.example.mrbug.sqliteexample.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by MrBug on 14.11.2017.
 */

public class sqlitelayer extends SQLiteOpenHelper {


    public sqlitelayer(Context context, String name, int version) {

        super(context,name,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String sqlcommand = "CREATE TABLE " + "Users" + "(id INTEGER PRIMARY KEY,name TEXT,surname TEXT" + ")";
            db.execSQL(sqlcommand);
        }
            catch(Exception e ){
                Log.e("tablo kurulamadı", "exception", e);
            }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlcommand = " drop table if exist Users";
        db.execSQL(sqlcommand);
    }
}
