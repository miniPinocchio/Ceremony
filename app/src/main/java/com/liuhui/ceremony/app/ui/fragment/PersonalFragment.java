package com.liuhui.ceremony.app.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * "我的"选项卡
 * Created by anany on 15/8/14.
 */
public class PersonalFragment extends BaseFragment {

	@Override
	public View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.fragment_personal, container, false);
		ButterKnife.findById(view, R.id.back).setVisibility(View.GONE);
		((TextView)ButterKnife.findById(view, R.id.actionBarTitle)).setText(R.string.me);
		return view;
	}

	@Override
	public void initData() {

	}
}
