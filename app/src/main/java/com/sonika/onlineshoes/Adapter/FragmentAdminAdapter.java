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
import com.sonika.onlineshoes.Pojo.UserInfo;
import com.sonika.onlineshoes.R;
import com.sonika.onlineshoes.Pojo.Datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonika on 5/9/2017.
 */

public class FragmentAdminAdapter extends ArrayAdapter<UserInfo>{
    Context context;
    List<UserInfo> objects = new ArrayList<>();
    int resource;

    public FragmentAdminAdapter(Context context, int resource, List<UserInfo> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;

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
            holder.name = (TextView)row.findViewById(R.id.name);
            holder.password = (TextView) row.findViewById(R.id.password);
            holder.email = (TextView)row.findViewById(R.id.email);
            holder.contact = (TextView)row.findViewById(R.id.contact);

            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }

        UserInfo userInfo = objects.get(position);
        holder.name.setText("Name:"+" "+userInfo.getName());
        holder.password.setText("Password:"+" "+userInfo.getPassword());
        holder.email.setText("Email:"+" "+userInfo.getEmail());
        holder.contact.setText("Contact:"+" "+userInfo.getContact());

        return row;
    }


    static class ViewHolder {
        TextView name, password, contact, email;
    }


}

