package com.liuhui.ceremony.app.activity;

import android.view.View;
import android.widget.EditText;
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

	@InjectView(R.id.mobilePhone)
	EditText mobilePhone;

	@InjectView(R.id.password)
	EditText password;

	@Override
	protected void initViews() {
		setContentView(R.layout.fragment_login);

		ButterKnife.inject(this);

		title.setText(R.string.login_title);
		rightText.setText(R.string.cancel);
	}

	/**
	 * 设置按钮的点击事件
	 */
	@OnClick(value = { R.id.back, R.id.actionBarRightText, R.id.goHome,
			R.id.login, R.id.register, R.id.forgetPassword })
	void setClickEvent(View v) {
		switch(v.getId()) {
			case R.id.back:
				finish();
				break;
			case R.id.actionBarRightText:
				break;
			case R.id.goHome:
				break;
			case R.id.login:
				break;
			case R.id.register:
				break;
			case R.id.forgetPassword:
				break;
		}
	}

	/**
	 * 登录操作
	 */
	private void login() {
		String strMobilePhone = mobilePhone.getText().toString();
		String strPassword = password.getText().toString();
	}
}
