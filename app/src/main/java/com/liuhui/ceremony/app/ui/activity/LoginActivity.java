package com.liuhui.ceremony.app.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.liuhui.ceremony.app.Api;
import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.BuildConfig;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;
import com.liuhui.ceremony.app.bean.LoginResponseBody;
import com.liuhui.ceremony.app.constant.RequestParam;
import com.liuhui.ceremony.app.util.OkHttpClientManager;
import com.squareup.okhttp.Request;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * 登陆界面
 * <p/>
 * Created by __Berial___
 */
public class LoginActivity extends BaseActivity {

	@InjectView(R.id.actionBarTitle)
	TextView title;

	@InjectView(R.id.mobilePhone)
	EditText mobilePhone;

	@InjectView(R.id.password)
	EditText password;

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_login);

		ButterKnife.inject(this);

		ButterKnife.findById(this, R.id.back).setVisibility(View.GONE);
		title.setText(R.string.login_title);

		if(BuildConfig.DEBUG) {
			mobilePhone.setText("18007770951");
			password.setText("xiayu215");
		}
	}

	/**
	 * 设置按钮的点击事件
	 */
	@OnClick({ R.id.goHome, R.id.login, R.id.register, R.id.forgetPassword })
	void setClickEvent(View v) {
		switch(v.getId()) {
			case R.id.goHome:
				startActivity(new Intent(this, MainActivity.class));
				break;
			case R.id.login:
				login();
				break;
			case R.id.register:
				startActivity(new Intent(this, RegisterActivity.class));
				break;
			case R.id.forgetPassword:
				startActivity(new Intent(this, ForgetPasswordActivity.class));
				break;
		}
	}

	/**
	 * 登录操作
	 */
	private void login() {
		final String strMobilePhone = mobilePhone.getText().toString();
		final String strPassword = password.getText().toString();

		if(strMobilePhone.length() == 0) {
			BaseApplication.toast("未输入手机号");
			return;
		} else if(strMobilePhone.length() < 11) {
			BaseApplication.toast("手机号未输入完整");
			return;
		} else if(!BaseApplication.isMobilePhone(strMobilePhone)) {
			BaseApplication.toast("不存在此手机号");
			return;
		} else if(strPassword.length() == 0) {
			BaseApplication.toast("未输入密码");
			return;
		} else if(strPassword.length() < 6) {
			BaseApplication.toast("密码未输入完整");
			return;
		}

		//登陆
		OkHttpClientManager.postAsyn(Api.LOGIN, new OkHttpClientManager.ResultCallback<LoginResponseBody>() {

					@Override
					public void onError(Request request, Exception e) {
						BaseApplication.toast("登录失败，请重试");
					}

					@Override
					public void onResponse(LoginResponseBody response) {
						switch(response.getStatus()) {
							case "1":
								BaseApplication.setUserId(response.getUserid());
								startActivity(new Intent(LoginActivity.this, MainActivity.class));
								finish();
								break;
							case "0":
								BaseApplication.toast("登录失败，请重试");
								break;
						}
					}
				},
				new OkHttpClientManager.Param(RequestParam.MOBILE, strMobilePhone),
				new OkHttpClientManager.Param(RequestParam.PASSWORD, strPassword));
	}
}
