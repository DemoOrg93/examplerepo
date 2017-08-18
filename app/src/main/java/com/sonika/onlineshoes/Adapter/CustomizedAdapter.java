package com.sonika.onlineshoes.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sonika.onlineshoes.R;
import com.sonika.onlineshoes.Pojo.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class CustomizedAdapter extends ArrayAdapter<UserInfo> {

    Context context;
    int layoutResourceId;
    List<UserInfo> taskList = new ArrayList<>();
    int i=0;

    public CustomizedAdapter(Context context, int layoutResourceId, List<UserInfo> taskList) {
        super(context, layoutResourceId, taskList);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.taskList = taskList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        TaskHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new TaskHolder();
            holder.name = (TextView)row.findViewById(R.id.name);
            holder.password = (TextView)row.findViewById(R.id.password);
            holder.email = (TextView)row.findViewById(R.id.email);
            holder.contact = (TextView)row.findViewById(R.id.contact);


            row.setTag(holder);
        }
        else
        {
            holder = (TaskHolder)row.getTag();
        }

        UserInfo userInfo = taskList.get(position);
        holder.name.setText("Name:"+ " " +userInfo.getName());
        holder.password.setText("Password:"+ " " +userInfo.getPassword());
        holder.contact.setText("Contact:"+ " " +userInfo.getContact());
        holder.email.setText("Email:"+ " " +userInfo.getEmail());


        return row;
    }

    static class TaskHolder
    {
        TextView name, password, email, contact;

    }
}

