package com.liuhui.ceremony.app.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * 登陆界面
 * <p/>
 * Created by __Berial___
 */
public class LoginActivity extends BaseActivity {

	@InjectView(R.id.back)
	ImageView back;

	@InjectView(R.id.actionBarTitle)
	TextView title;

	@InjectView(R.id.actionBarRightText)
	TextView rightText;

	@InjectView(R.id.forgetPassword)
	TextView forgetPassword;

	@Override
	protected void initViews() {
		setContentView(R.layout.fragment_login);

		ButterKnife.inject(this);

		title.setText(R.string.login_title);
		rightText.setText(R.string.cancel);
	}

	@OnClick(value = { R.id.back, R.id.actionBarRightText })
	void setClickEvent(View v) {
		switch(v.getId()) {
			case R.id.back:
				finish();
				break;
			case R.id.actionBarRightText:
				break;
		}
	}
}
