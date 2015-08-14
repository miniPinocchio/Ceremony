package com.liuhui.ceremony.app.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.liuhui.ceremony.app.Api;
import com.liuhui.ceremony.app.App;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;
import com.liuhui.ceremony.app.constant.RequestParam;
import com.liuhui.ceremony.app.util.LogUtil;
import com.liuhui.ceremony.app.util.OkHttpUtil;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * 登陆界面
 * <p/>
 * Created by __Berial___
 */
public class LoginFragment extends BaseActivity {

	@InjectView(R.id.actionBarTitle)
	TextView title;

	@InjectView(R.id.actionBarRightText)
	TextView rightText;

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
				login();
				break;
			case R.id.register:
				startActivity(new Intent(this, RegisterFragment.class));
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

		if(strMobilePhone.length() == 0) {
			App.toast("未输入手机号");
			return;
		} else if(strMobilePhone.length() < 11) {
			App.toast("手机号未输入完整");
			return;
		} else if(!App.isMobilePhone(strMobilePhone)) {
			App.toast("不存在此手机号");
			return;
		} else if(strPassword.length() == 0) {
			App.toast("未输入密码");
			return;
		} else if(strPassword.length() < 6) {
			App.toast("密码未输入完整");
			return;
		}

		RequestBody requestBody = new FormEncodingBuilder()
				.add(RequestParam.MOBILE, strMobilePhone)
				.add(RequestParam.PASSWORD, strPassword).build();

		Request loginRequest = new Request.Builder()
				.url(Api.LOGIN)
				.post(requestBody)
				.build();

		OkHttpUtil.enqueue(loginRequest, new Callback() {
			@Override
			public void onFailure(Request request, IOException e) {
				//				App.toast("登录失败，请重试");
				LogUtil.e("登录失败，请重试");
			}

			@Override
			public void onResponse(Response response) throws IOException {
				//				App.toast(response.body().string());
				LogUtil.e(response.body().string());
			}
		});
	}
}
