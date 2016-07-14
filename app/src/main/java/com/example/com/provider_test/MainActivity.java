package com.example.com.provider_test;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visitedDB();
    }
    public void visitedDB()
    {
        String path = "content://com.example.com.visitDB.provider/query";
        Uri uri = Uri.parse(path);
        ContentResolver resolver  = getContentResolver();
        Cursor cursor = resolver.query(uri,null,null,null,null);
        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String sex = cursor.getString(cursor.getColumnIndex("sex"));
            System.out.println(id+"---"+name+"---"+sex);
        }
    }
}
