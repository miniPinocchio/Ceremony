package com.liuhui.ceremony.app.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;

import butterknife.InjectView;


/**
 * 登陆界面
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

	@InjectView(R.id.back)
	ImageView back;

	@InjectView(R.id.actionBarTitle)
	TextView title;

	@InjectView(R.id.actionBarRightText)
	TextView rightText;

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_login);
		back.setOnClickListener(this);

		title.setText(R.string.login_title);
		rightText.setText(R.string.cancel);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.back:
				finish();
				break;
		}
	}
}
