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


public class PagerrAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerrAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                LadiesFragment1 tab1 = new LadiesFragment1();
                return tab1;
            case 1:
                GentsFragment2 tab2 = new GentsFragment2();
                return tab2;
            case 2:
                KidsFragment3 tab3 = new KidsFragment3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
