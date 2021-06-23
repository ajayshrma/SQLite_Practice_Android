package com.ajayshrma.sqlite_insert;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myhepler extends SQLiteOpenHelper {


    private static final String dbname = "mydb";
    private static final int version = 1;

    public myhepler(Context context){
        super(context,dbname,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE PRODUCTS( _id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, PRICE REAL)";

        db.execSQL(sql);
        insertData("Bread","Brown Bread",24.90,db);
        insertData("Milk"," cow Bread",24.90,db);
        insertData("Bisciut","Brown Biscuit",24.90,db);

    }

    private void insertData(String name, String description,double price, SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put("Name",name);
        values.put("Description",description);
        values.put("Price",price);
        database.insert("PRODUCTS",null,values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
