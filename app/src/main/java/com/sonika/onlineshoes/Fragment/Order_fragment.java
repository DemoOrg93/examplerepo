package com.sonika.onlineshoes.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sonika.onlineshoes.Adapter.OrderAdapter;
import com.sonika.onlineshoes.Helper.DBHelperOrder;
import com.sonika.onlineshoes.Pojo.OrderInfo;
import com.sonika.onlineshoes.R;

import java.util.ArrayList;


public class Order_fragment extends Fragment {

    ListView lv;
    DBHelperOrder dbHelperOrder;
    OrderInfo orderInfo;
    ArrayList<OrderInfo> data = new ArrayList<OrderInfo>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_order_fragment, container, false);
        perform(v);
        return v;

    }



    private void perform(View v) {

        lv = (ListView) v.findViewById(R.id.list_order);
        dbHelperOrder = new DBHelperOrder(getActivity());


        final ArrayList<OrderInfo> listOrder = dbHelperOrder.getOrderMessage();
        for (int i = 0; i < listOrder.size(); i++) {
            final OrderInfo info = listOrder.get(i);
            final OrderAdapter notifyAdapter = new OrderAdapter(getActivity(),
                    R.layout.order_try, listOrder);
            lv.setAdapter(notifyAdapter);
            lv.deferNotifyDataSetChanged();


        }
    }
}