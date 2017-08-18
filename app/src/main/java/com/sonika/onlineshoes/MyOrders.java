package com.sonika.onlineshoes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.sonika.onlineshoes.Adapter.OrderAdapter;
import com.sonika.onlineshoes.Helper.DBHelperOrder;
import com.sonika.onlineshoes.Pojo.OrderInfo;

import java.util.ArrayList;

public class MyOrders extends AppCompatActivity {

    ListView listView;
    DBHelperOrder dBhelperOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        listView = (ListView) findViewById(R.id.list_myorders);
        dBhelperOrders = new DBHelperOrder(MyOrders.this);
        show();

    }

    private void show() {
        final ArrayList<OrderInfo> list = dBhelperOrders.getOrderMessage();
        for (int i = 0; i < list.size(); i++) {
            final OrderInfo info = list.get(i);
            final OrderAdapter notifyAdapter = new OrderAdapter(MyOrders.this, R.layout.order_try, list);
            listView.setAdapter(notifyAdapter);
            listView.deferNotifyDataSetChanged();



        }
    }
}
