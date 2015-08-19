package com.liuhui.ceremony.app.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.liuhui.ceremony.app.Api;
import com.liuhui.ceremony.app.App;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;
import com.liuhui.ceremony.app.bean.AuthCode;
import com.liuhui.ceremony.app.bean.ResponseBody;
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
 * 注册界面
 * <p/>
 * Created by berial on 15/8/14.
 */
public class RegisterActivity extends BaseActivity {

	@InjectView(R.id.mobilePhone)
	EditText mobilePhone;

	@InjectView(R.id.password)
	EditText password;

	@InjectView(R.id.confirmPassword)
	EditText confirmPassword;

	@InjectView(R.id.authCode)
	EditText authCode;

	private String strAuthCode;

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_register);
		ButterKnife.inject(this);
		((TextView)ButterKnife.findById(this, R.id.actionBarTitle)).setText(R.string.register_title);
	}

	/**
	 * 设置按钮的点击事件
	 */
	@OnClick({ R.id.back, R.id.register, R.id.getAuthCode })
	void setClickEvent(View v) {
		switch(v.getId()) {
			case R.id.back:
				finish();
				break;
			case R.id.register:
				register();
				break;
			case R.id.getAuthCode:
				getAuthCode();
				break;
		}
	}

	/**
	 * 获取短信验证码操作
	 */
	private void getAuthCode() {
		String strMobilePhone = mobilePhone.getText().toString();
		if(strMobilePhone.length() == 0) {
			App.toast("未输入手机号");
			return;
		} else if(strMobilePhone.length() < 11) {
			App.toast("手机号未输入完整");
			return;
		} else if(!App.isMobilePhone(strMobilePhone)) {
			App.toast("不存在此手机号");
			return;
		}

		RequestBody requestBody = new FormEncodingBuilder()
				.add(RequestParam.MOBILE, strMobilePhone)
				.build();

		Request getAuthCodeRequest = new Request.Builder()
				.url(Api.GET_AUTH_CODE)
				.post(requestBody)
				.build();

		OkHttpUtil.enqueue(getAuthCodeRequest, new Callback() {
			@Override
			public void onFailure(Request request, IOException e) {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						App.toast("获取验证码失败，请重试");
					}
				});
			}

			@Override
			public void onResponse(Response response) throws IOException {
				AuthCode objAuthCode = new Gson().fromJson(response.body().string(),
						AuthCode.class);
				strAuthCode = objAuthCode.getPincode();
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						App.toast(strAuthCode);
						authCode.setText(strAuthCode);
					}
				});
			}
		});
	}

	/**
	 * 注册操作
	 */
	private void register() {
		String strMobilePhone = mobilePhone.getText().toString();
		String strPassword = password.getText().toString();
		String strConfirmPassword = confirmPassword.getText().toString();
		String strAuthCode = authCode.getText().toString();

		if(strMobilePhone.length() == 0) {
			App.toast("未输入手机号");
			return;
		} else if(strMobilePhone.length() < 11) {
			App.toast("手机号未输入完整");
			return;
		} else if(!App.isMobilePhone(strMobilePhone)) {
			App.toast("不存在此手机号");
			return;
		} else if(strPassword.length() == 0 || strConfirmPassword.length() == 0) {
			App.toast("未输入密码");
			return;
		} else if(strPassword.length() < 6 || strConfirmPassword.length() == 0) {
			App.toast("密码未输入完整");
			return;
		} else if(!strPassword.equals(strConfirmPassword)) {
			App.toast("两次输入的密码不一致");
			return;
		} else if(strAuthCode.length() == 0) {
			App.toast("未输入短信验证码");
			return;
		} else if(!strAuthCode.equals(this.strAuthCode)) {
			App.toast("短信验证码输入错误");
			return;
		}

		final RequestBody requestBody = new FormEncodingBuilder()
				.add(RequestParam.MOBILE, strMobilePhone)
				.add(RequestParam.PASSWORD, strPassword)
				.add(RequestParam.AUTH_CODE, strAuthCode)
				.build();

		Request loginRequest = new Request.Builder()
				.url(Api.REGISTER)
				.post(requestBody)
				.build();

		OkHttpUtil.enqueue(loginRequest, new Callback() {
			@Override
			public void onFailure(Request request, IOException e) {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						App.toast("注册失败，请重试");
					}
				});
			}

			@Override
			public void onResponse(Response response) throws IOException {
				final ResponseBody responseBody = new Gson().fromJson(response.body().string(),
						ResponseBody.class);
				LogUtil.e(requestBody.toString());
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						switch(responseBody.getStatus()) {
							case "1":
								App.toast("注册成功");
								finish();
								break;
							case "0":
								App.toast("注册失败，请重试");
								break;
						}
					}
				});
			}
		});
	}
}
