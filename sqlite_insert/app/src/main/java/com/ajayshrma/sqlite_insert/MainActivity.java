package com.ajayshrma.sqlite_insert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myhepler myhepler = new myhepler(this);
        SQLiteDatabase database = myhepler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("PRICE", 200.00);

        database.update("PRODUCTS",values, "_id =?",new String[]{"1"});

        database.delete("PRODUCTS", "_id =?", new String[]{"1"});

        Cursor cursor = database.rawQuery("SELECT NAME,PRICE FROM PRODUCTS WHERE NAME=?", new String[]{"Milk"});
        if (cursor != null){
            cursor.moveToFirst();
        }

        StringBuilder builder = new StringBuilder();

        do {
            String name = cursor.getString(0);
            double price = cursor.getDouble(1);

            builder.append("NAME -" +name + "PRICE-"+price);

        }while (cursor.moveToNext());

        TextView textView = (TextView) findViewById(R.id.textdata);

        textView.setText(builder.toString());
        }


    }
