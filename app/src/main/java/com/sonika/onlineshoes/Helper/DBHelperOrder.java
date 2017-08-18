package com.sonika.onlineshoes.Helper;

/**
 * Created by sonika on 5/4/2017.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sonika.onlineshoes.Pojo.OrderInfo;
import com.sonika.onlineshoes.Pojo.UserInfo;

import java.util.ArrayList;

/**

 */
public class DBHelperOrder extends SQLiteOpenHelper {
    static  int DATABASE_VERSION = 1;
    static String DATABASE_NAME = "user_order";


    String ORDER_TABLE = "CREATE TABLE if not exists `user_order`  (\n" +
            "                       `id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "                       `shoe_id` TEXT,\n" +
            "                       `name` TEXT,\n" +
            "                       `address` TEXT,\n" +
            "                       `email` TEXT,\n" +
            "                       `color` TEXT,\n" +
            "                       `size` TEXT,\n" +
            "                       `delivery_date`TEXT\n" +
            "                      );";


    public DBHelperOrder(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        getWritableDatabase().execSQL(ORDER_TABLE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertOrderInfo(ContentValues cv ){
        getWritableDatabase().insert("user_order","",cv);

    }

    public ArrayList<OrderInfo> getOrderMessage(){
        String sql="select * from user_order";
        ArrayList<OrderInfo> list=new ArrayList<OrderInfo>();
        Cursor cursor=getWritableDatabase().rawQuery(sql,null);
        while (cursor.moveToNext()){
            OrderInfo info=new OrderInfo();
            info.id=cursor.getString(cursor.getColumnIndex("id"));
            info.shoe_id =cursor.getString(cursor.getColumnIndex("shoe_id"));
            info.name=cursor.getString(cursor.getColumnIndex("name"));
            info.address=cursor.getString(cursor.getColumnIndex("address"));
            info.email=cursor.getString(cursor.getColumnIndex("email"));
            info.color=cursor.getString(cursor.getColumnIndex("color"));
            info.size=cursor.getString(cursor.getColumnIndex("size"));
            info.deliveryDate=cursor.getString(cursor.getColumnIndex("delivery_date"));

            list.add(info);
        }
        cursor.close();
        return list;
    }
    public Integer delete(String id) {
        getWritableDatabase().delete("user_order", "id=" +id, null);

        return null;
    }

    public void deleteNotif(int _id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("user_order", "id=" + _id, null);
    }



}
