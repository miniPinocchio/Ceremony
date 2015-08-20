package com.liuhui.ceremony.app.ui.customview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class UnScrollViewPager extends ViewPager {

	public UnScrollViewPager(Context context) {
		super(context);
	}

	public UnScrollViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return false;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		return false;
	}
}
