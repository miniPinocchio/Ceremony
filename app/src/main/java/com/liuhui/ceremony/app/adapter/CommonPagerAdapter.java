package com.liuhui.ceremony.app.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * 通用的PagerAdapter(非Fragment)
 * <p/>
 * Created by berial on 15/7/28.
 */
public class CommonPagerAdapter extends PagerAdapter {

	/**
	 * 储存需要展示的View
	 */
	private ArrayList<? extends View> mViews;

	public CommonPagerAdapter(@NonNull ArrayList<? extends View> views) {
		mViews = views;
	}

	@Override
	public int getCount() {
		return mViews != null ? mViews.size() : 0;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		View view = mViews.get(position);
		container.removeView(view);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = mViews.get(position);
		container.addView(view);
		return view;
	}
}
