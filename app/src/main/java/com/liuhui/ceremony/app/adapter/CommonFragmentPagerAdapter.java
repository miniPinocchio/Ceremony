package com.liuhui.ceremony.app.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 通用的FragmentPagerAdapter
 * <p/>
 * Created by berial on 15/7/28.
 */
public class CommonFragmentPagerAdapter extends FragmentPagerAdapter {

	private ArrayList<? extends Fragment> mFragments;

	public CommonFragmentPagerAdapter(@NonNull FragmentManager fm) {
		super(fm);
	}

	public CommonFragmentPagerAdapter setFragmentArray(@NonNull ArrayList<? extends Fragment> fragments) {
		mFragments = fragments;
		return this;
	}

	@Override
	public Fragment getItem(int position) {
		return mFragments.get(position);
	}

	@Override
	public int getCount() {
		return mFragments != null ? mFragments.size() : 0;
	}
}
