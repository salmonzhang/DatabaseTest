package com.example.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by salmonzhang on 2019/12/9.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK = "create table Book ("
            + "id integer primary key autoincrement, " //将id设为主键，并自动增长
            + "author text,"   //文本类型
            + "price real,"    //浮点类型
            + "pages integer," //整型
            + "name text)";     //blob表示二进制类型

    public static final String CREATE_CATEGORY = "create table Category ("
            + "id integer primary key autoincrement, " //将id设为主键，并自动增长
            + "category_name text,"     //文本类型
            + "category_code integer)"; //整型
    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK); //创建Book表
        db.execSQL(CREATE_CATEGORY); //创建Category表
//        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
}
