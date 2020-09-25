package com.example.dome05;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_PERSON = "create table Person ("
            + "pid integer primary key, "
            + "iid integer,"
            + "name text,"
            + "num text,"
            + "mid integer)";

    public static final String CREATE_RECENT = "create table Recent ("
            + "pid integer primary key, "
            + "name text,"
            + "phone text,"
            + "time text,"
            + "timelong text)";


    private Context mContext;

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PERSON);
        db.execSQL(CREATE_RECENT);


//在这里初始化数据的话只会执行一次
//        ContentValues values = new ContentValues();
//        List<Integer> imgIds = new ArrayList<>();
//        imgIds.add(R.drawable.img_1);
//        imgIds.add(R.drawable.img_2);
//        imgIds.add(R.drawable.img_3);
//        imgIds.add(R.drawable.img_4);
//        imgIds.add(R.drawable.img_5);
//        imgIds.add(R.drawable.img_6);
//        imgIds.add(R.drawable.img_7);
//        imgIds.add(R.drawable.img_8);
//        imgIds.add(R.drawable.img_9);
//        imgIds.add(R.drawable.img_10);
//        imgIds.add(R.drawable.img_11);
//        imgIds.add(R.drawable.img_12);
//        imgIds.add(R.drawable.img_13);
//        imgIds.add(R.drawable.img_14);
//        imgIds.add(R.drawable.img_15);
//        imgIds.add(R.drawable.img_16);
//        imgIds.add(R.drawable.img_17);
//        imgIds.add(R.drawable.img_18);
//        imgIds.add(R.drawable.img_19);
//        imgIds.add(R.drawable.img_20);
//        imgIds.add(R.drawable.img_21);
//        imgIds.add(R.drawable.img_22);
//        imgIds.add(R.drawable.img_23);
//        imgIds.add(R.drawable.img_24);
//        imgIds.add(R.drawable.img_25);
//        for (int i = 1; i<=25 ;i++) {
//            values.put("pid",i);
//            values.put("iid",imgIds.get(i-1));
//            values.put("name","Person"+i);
//            values.put("num","123456789"+i);
//            values.put("mid",R.raw.bird);
//            db.insert("Person",null,values);
//            values.clear();
//        }
//
//        ContentValues values2 = new ContentValues();
//        for (int i = 1; i<=25 ;i++) {
//            if(i % 2 ==0){
//                values2.put("pid",i);
//                values2.put("name","zs");
//                values2.put("phone","13562247952");
//                values2.put("time","2020-9-15");
//                values2.put("timelong","8min");
//                db.insert("Recent",null,values2);
//                values2.clear();
//            }else{
//                values2.put("pid",i);
//                values2.put("name","lslyb");
//                values2.put("phone","16587896520");
//                values2.put("time","2020-9-14");
//                values2.put("timelong","3min");
//                db.insert("Recent",null,values2);
//                values2.clear();
//            }
//
//        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Person");
        db.execSQL("drop table if exists Recent");
        onCreate(db);
    }
}
