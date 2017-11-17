package com.example.mrbug.sqliteexample.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mrbug.sqliteexample.entities.user;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by MrBug on 14.11.2017.
 */

public class sqlitedataaccess {
    //
    SQLiteDatabase db;
    //benim oluşturduğum
    sqlitelayer mydb;

    public sqlitedataaccess(Context ctx,int version) {
    //eğer veri tabanı ihç oluşturulmadıysa sqlitelayer in constructorın çalışacağı yer burası
    mydb = new sqlitelayer(ctx,"myserver",version);

    }

    //bağlantı açtık diğer bir deyişle kendi db mizden instance aldık
    public void open(){
    //eğer veri tabanımız varsa db olarak instance alıyoruz yoksa sqlite'ın oncreate'i çalışacak
    db=mydb.getWritableDatabase();
    }

    //bağlantı kapadık
    public void close(){
        mydb.close();
    }

    public void createuser(user newuser){

        ContentValues val = new ContentValues();
        val.put("name",newuser.getName());
        val.put("surname",newuser.getSurname());

        //INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
        //VALUES (1, 'Paul', 32, 'California', 20000.00 );
      //  String createquery= "INSERT INTO users (name,surname) VALUES ('+'"sad"'+','asda')";

        Long scopedId=(Long) db.insert("Users",null,val);
    }

    public void  deleteuser(user deleteduser){

        db.delete("Users","id="+deleteduser.getId(),null);
    }

    public List<user> getUserlist(){

        List<user> users = new ArrayList<>();

        //veritabanı kayıtları içinde teker teker gezen bir pointerdır.
        //("tablo adı",istenen kolonlar,selection,selectionargs,groupby,having,orderby)
        Cursor  cursor =db.query("Users",new String[]{"id", "name", "surname"},null,null,null,null,null);


        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            //cursorget kolon indexini parametre alır
        Integer id = cursor.getInt(0);
        String name = cursor.getString(1);
        String surname = cursor.getString(2);

        users.add(new user(id,name,surname));

        cursor.moveToNext();
        }

        cursor.close();
        return users;
    }
}
