package com.liuhui.ceremony.app.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuhui.ceremony.app.util.LogUtil;

import butterknife.ButterKnife;

/**
 * Fragment基类
 * <p/>
 * Created by __Berial___
 */
public abstract class BaseFragment extends Fragment {

	public Activity mActivity;
	/**
	 * Fragment当前状态是否可见
	 */
	protected boolean isVisible;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = activity;
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		isVisible = getUserVisibleHint();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = initView(inflater, container);
		ButterKnife.inject(this, view);
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		LogUtil.e("BaseFragment onResume ---");
		if(isVisible) {
			initData();
		}
	}

	/**
	 * 子类必须实现此方法, 返回一个View对象, 作为当前Fragment的布局来展示.
	 */
	public abstract View initView(LayoutInflater inflater, ViewGroup container);

	/**
	 * 子类需要初始化自己的数据
	 */
	public abstract void initData();

}
