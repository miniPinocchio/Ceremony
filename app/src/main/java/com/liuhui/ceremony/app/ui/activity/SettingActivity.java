package com.liuhui.ceremony.app.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置界面
 * <p/>
 * Created by berial on 15/8/19.
 */
public class SettingActivity extends BaseActivity {

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_setting);
		ButterKnife.inject(this);
		((TextView) ButterKnife.findById(this, R.id.actionBarTitle)).setText(R.string.setting);
	}

	/**
	 * 设置点击事件
	 */
	@OnClick({ R.id.back, R.id.logOut, R.id.securitySetting, R.id.noticeSetting })
	void setClickEvent(View view) {
		switch(view.getId()) {
			case R.id.back:
				finish();
				break;
			case R.id.logOut:
				//TODO 注销操作
				break;
			case R.id.securitySetting:
				startActivity(new Intent(this, SecuritySettingActivity.class));
				break;
			case R.id.noticeSetting:
				//TODO 通知设置
				break;
		}
	}
}
