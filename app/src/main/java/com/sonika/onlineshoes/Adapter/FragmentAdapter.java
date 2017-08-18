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
import com.sonika.onlineshoes.R;
import com.sonika.onlineshoes.Pojo.Datamodel;

import java.util.ArrayList;
import java.util.List;


public class FragmentAdapter extends ArrayAdapter<Datamodel>{
    Context context;
    List<Datamodel> objects = new ArrayList<>();
    int resource;

    public FragmentAdapter(Context context, int resource, List<Datamodel> objects) {
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
            holder.textViewprice = (TextView)row.findViewById(R.id.price);
            holder.imageView = (ImageView) row.findViewById(R.id.image);
            holder.textViewDesc = (TextView) row.findViewById(R.id.desc);


            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }

            Datamodel userInfo = objects.get(position);
            holder.textViewprice.setText("Price:"+" "+userInfo.getPrice());
            holder.textViewDesc.setText(userInfo.getDescription());


    Glide.with(getContext()).load(userInfo.getImage()).into(holder.imageView);
//      Glide.with(getContext()).load("http://goo.gl/gEgYUd")
//              .thumbnail(0.5f)
//              .crossFade()
//            //  .diskCacheStrategy(DiskCacheStrategy.ALL)
//              .into(holder.imageView);
      return row;
    }


    static class ViewHolder {
        TextView textViewprice, textViewDesc;
        ImageView imageView;
    }


}

