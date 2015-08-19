package com.liuhui.ceremony.app.ui.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseFragment;
import com.liuhui.ceremony.app.ui.activity.SettingActivity;
import com.liuhui.ceremony.app.ui.customview.roundedimageview.RoundedImageView;
import com.liuhui.ceremony.app.util.LogUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * "我的"选项卡
 * <p></>
 * Created by __Berial___ on 15/8/14.
 */
public class PersonalFragment extends BaseFragment {

	@InjectView(R.id.avatar)
	RoundedImageView avatar;

	@InjectView(R.id.nickname)
	TextView nickname;

	@Override
	public View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.fragment_personal, container, false);
		ButterKnife.findById(view, R.id.back).setVisibility(View.GONE);
		((TextView) ButterKnife.findById(view, R.id.actionBarTitle)).setText(R.string.me);
		return view;
	}

	@Override
	public void initData() {
		LogUtil.e("PersonalFragment initData ---");
	}

	/**
	 * 设置点击事件
	 */
	@OnClick({ R.id.userInfo, R.id.gradeRecord, R.id.impressionRecord, R.id.myStory,
			R.id.myFavorite, R.id.setting })
	void setClickEvent(View view) {
		switch(view.getId()) {
			case R.id.userInfo:
				break;
			case R.id.gradeRecord:
				break;
			case R.id.impressionRecord:
				break;
			case R.id.myStory:
				break;
			case R.id.myFavorite:
				break;
			case R.id.setting:
				startActivity(new Intent(mActivity, SettingActivity.class));
				break;
		}
	}
}
