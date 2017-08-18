package com.sonika.onlineshoes.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sonika.onlineshoes.Adapter.CustomizedAdapter;
import com.sonika.onlineshoes.Helper.DBHelper;
import com.sonika.onlineshoes.Pojo.UserInfo;
import com.sonika.onlineshoes.R;

import java.util.ArrayList;


public class User_fragment extends Fragment {

    ListView mlist;
    DBHelper dbhelper;
    UserInfo info;
    ArrayList<UserInfo> data = new ArrayList<UserInfo>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_user_fragment, container, false);
        perform(v);
        return v;

    }

    private void perform(View v) {

        mlist = (ListView) v.findViewById(R.id.list_users);
        dbhelper = new DBHelper(getActivity());
        final ArrayList<UserInfo> list = dbhelper.getMessage();
        for (int i = 0; i < list.size(); i++) {
            final UserInfo info = list.get(i);
            final CustomizedAdapter notifyAdapter = new CustomizedAdapter(getActivity(), R.layout.activity_fragment_admin_adapter, list);
            mlist.setAdapter(notifyAdapter);
            mlist.deferNotifyDataSetChanged();


        }
    }
}