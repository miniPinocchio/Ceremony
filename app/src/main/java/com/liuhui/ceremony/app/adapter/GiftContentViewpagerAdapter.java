package com.liuhui.ceremony.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by anany on 15/8/19.
 */
public class GiftContentViewpagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;

    public GiftContentViewpagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}
