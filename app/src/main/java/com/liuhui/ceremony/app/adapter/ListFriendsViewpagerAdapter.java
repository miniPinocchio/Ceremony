package com.liuhui.ceremony.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.ceremony.app.adapter
 * user  Pinocchio
 * Date 2015/8/16
 * Email:liu594545591@126.com
 */
public class ListFriendsViewpagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public ListFriendsViewpagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        int ret = 0;

        if (fragments != null) {
            ret = fragments.size();
        }

        return ret;
    }


}
