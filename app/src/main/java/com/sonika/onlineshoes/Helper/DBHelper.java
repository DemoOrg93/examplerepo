package com.sonika.onlineshoes.Helper;

/**
 * Created by sonika on 5/4/2017.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.sonika.onlineshoes.Pojo.UserInfo;

import java.util.ArrayList;

/**

 */
public class DBHelper extends SQLiteOpenHelper {
    static  int DATABASE_VERSION = 1;
    static String DATABASE_NAME = "Notification";


    String CREATE_NOTIFICATION_TABLE = "CREATE TABLE if not exists `user`  (\n" +
            "                       `id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "                       `name` TEXT,\n" +
            "                       `password` TEXT,\n" +
            "                       `email` TEXT,\n" +
            "                       `contact`TEXT\n" +
             "                      );";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        getWritableDatabase().execSQL(CREATE_NOTIFICATION_TABLE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertInfo(ContentValues cv ){
        getWritableDatabase().insert("user","",cv);

    }
    //try

    public String getSinlgeEntry(String userName) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("LOGIN", null, " USERNAME=?",
                new String[] { userName }, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public ArrayList<UserInfo> getMessage(){
        String sql="select * from user";
        ArrayList<UserInfo> list=new ArrayList<UserInfo>();
        Cursor cursor=getWritableDatabase().rawQuery(sql,null);
        while (cursor.moveToNext()){
            UserInfo info=new UserInfo();
            info.id=cursor.getString(cursor.getColumnIndex("id"));
            info.name=cursor.getString(cursor.getColumnIndex("name"));
            info.password=cursor.getString(cursor.getColumnIndex("password"));
            info.email=cursor.getString(cursor.getColumnIndex("email"));
            info.contact=cursor.getString(cursor.getColumnIndex("contact"));

            list.add(info);
        }
        cursor.close();
        return list;
    }
    public Integer delete(String id) {
        getWritableDatabase().delete("user", "id=" +id, null);

        return null;
    }

    public void deleteNotif(int _id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("user", "id=" + _id, null);
    }

    public boolean isValidUser(String username,String password){
        String sql="Select count(*) from user where name='"+username+"' and password='"+password+"'";
        SQLiteStatement statement =getWritableDatabase().compileStatement(sql);
        long l=statement.simpleQueryForLong();
        if(l>0){
            return true;
        }
        else return false;



    }





}
