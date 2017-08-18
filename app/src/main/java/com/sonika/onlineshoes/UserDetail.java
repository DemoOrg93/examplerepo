package com.sonika.onlineshoes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.sonika.onlineshoes.Adapter.CustomizedAdapter;
import com.sonika.onlineshoes.Helper.DBHelper;
import com.sonika.onlineshoes.Pojo.UserInfo;

import java.util.ArrayList;

public class UserDetail extends AppCompatActivity {
    ListView listView;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_detail);
         listView = (ListView) findViewById(R.id.list);
        dbHelper = new DBHelper(this);
        showINfo();
    }
    public void showINfo() {
        final ArrayList<UserInfo> list = dbHelper.getMessage();
        for (int i = 0; i < list.size(); i++) {
            final UserInfo info = list.get(i);
            final CustomizedAdapter notifyAdapter = new CustomizedAdapter(UserDetail.this, R.layout.activity_customized_adapter, list);
            listView.setAdapter(notifyAdapter);
            listView.deferNotifyDataSetChanged();

        }
    }

}