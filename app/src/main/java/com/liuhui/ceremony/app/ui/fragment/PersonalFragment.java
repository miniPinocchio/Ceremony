package com.liuhui.ceremony.app.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseHomeFragment;
import com.liuhui.ceremony.app.constant.RequestParam;
import com.liuhui.ceremony.app.ui.activity.PersonalInfoActivity;
import com.liuhui.ceremony.app.ui.activity.SettingActivity;
import com.liuhui.ceremony.app.util.LogUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * "我的"选项卡
 * Created by Berial on 15/8/14.
 */
public class PersonalFragment extends BaseHomeFragment {

	@Override
	public View initView(LayoutInflater inflater, ViewGroup container) {

		LogUtil.e("PersonalFragment initView");

		View view = inflater.inflate(R.layout.fragment_personal, container, false);
		ButterKnife.findById(view, R.id.back).setVisibility(View.GONE);
		((TextView) ButterKnife.findById(view, R.id.actionBarTitle)).setText(R.string.me);
		return view;
	}

	@Override
	public void initData() {
		LogUtil.e("PersonalFragment initData ---");
	}

	@OnClick({ R.id.setting, R.id.personalInfo })
	void setClickEvent(View view) {
		switch(view.getId()) {
			case R.id.setting:
				startActivityForResult(new Intent(mActivity, SettingActivity.class), 0);
				break;
			case R.id.personalInfo:
				startActivity(new Intent(mActivity, PersonalInfoActivity.class));
				break;
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == Activity.RESULT_OK) {
			String strNickname = data.getStringExtra(RequestParam.NICKNAME);
			String strAvatarUrl = data.getStringExtra(RequestParam.AVATAR);
		}
	}
}
