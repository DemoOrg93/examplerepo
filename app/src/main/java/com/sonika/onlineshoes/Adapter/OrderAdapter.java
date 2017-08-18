package com.sonika.onlineshoes.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sonika.onlineshoes.Pojo.OrderInfo;
import com.sonika.onlineshoes.Pojo.UserInfo;
import com.sonika.onlineshoes.R;
import com.sonika.onlineshoes.Pojo.Datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonika on 5/9/2017.
 */

public class OrderAdapter extends ArrayAdapter<OrderInfo> {
    Context context;
    List<OrderInfo> objects = new ArrayList<OrderInfo>();
    int resource;
    TextView textView;
    OrderInfo o = new OrderInfo();





    public OrderAdapter(Context context, int resource, List<OrderInfo> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;



        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);


            holder = new ViewHolder();
            holder.shoe_id = (TextView)row.findViewById(R.id.id);
            holder.name = (TextView)row.findViewById(R.id.name);
            holder.color = (TextView) row.findViewById(R.id.color);
            holder.email = (TextView)row.findViewById(R.id.email);
            holder.address = (TextView)row.findViewById(R.id.address);
            holder.size = (TextView)row.findViewById(R.id.size);
            holder.deliveryDate = (TextView)row.findViewById(R.id.deliverydate);
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }



        OrderInfo orderInfo = objects.get(position);

        holder.shoe_id.setText("id:"+" "+orderInfo.getShoe_id());
        holder.name.setText("Name:"+" "+orderInfo.getName());
        holder.color.setText("Color:"+" "+orderInfo.getColor());
        holder.email.setText("Email:"+" "+orderInfo.getEmail());
        holder.address.setText("Address:"+" "+orderInfo.getAddress());
        holder.size.setText("Size:"+" "+orderInfo.getSize());
        holder.deliveryDate.setText("Delivery Date:"+" "+orderInfo.getDeliveryDate());


        return row;
    }





    static class ViewHolder {
        TextView  shoe_id, name, email, color, size, deliveryDate, address;;
    }


}





