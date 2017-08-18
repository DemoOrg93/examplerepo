package com.sonika.onlineshoes.Adapter;

/**
 * Created by aryans on 12/7/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sonika.onlineshoes.Fragment.LadiesFragment1;
import com.sonika.onlineshoes.Fragment.GentsFragment2;
import com.sonika.onlineshoes.Fragment.KidsFragment3;
import com.sonika.onlineshoes.Fragment.Order_fragment;
import com.sonika.onlineshoes.Fragment.User_fragment;


public class PagerAdminAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdminAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                 User_fragment user_fragment = new User_fragment();
                return user_fragment;
            case 1:
                Order_fragment order_fragment = new Order_fragment();
                return order_fragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
