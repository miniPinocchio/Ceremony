package com.liuhui.ceremony.app.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 通知设置
 * <p/>
 * Created by berial on 15/8/25.
 */
public class NoticeSettingActivity extends BaseActivity {

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_security_setting);
		ButterKnife.inject(this);
		((TextView) ButterKnife.findById(this, R.id.actionBarTitle))
				.setText(R.string.notice_setting);
	}

	/**
	 * 设置点击事件
	 */
	@OnClick({ R.id.back })
	void setClickEvent(View view) {
		switch(view.getId()) {
			case R.id.back:
				finish();
				break;
		}
	}
}
