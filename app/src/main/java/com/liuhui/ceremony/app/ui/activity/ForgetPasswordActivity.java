package com.liuhui.ceremony.app.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.liuhui.ceremony.app.Api;
import com.liuhui.ceremony.app.BaseApplication;
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
 * 忘记密码界面
 * <p/>
 * Created by berial on 15/8/18.
 */
public class ForgetPasswordActivity extends BaseActivity {

	@InjectView(R.id.mobilePhone)
	EditText mobilePhone;

	@InjectView(R.id.password)
	EditText password;

	@InjectView(R.id.confirmPassword)
	EditText confirmPassword;

	@InjectView(R.id.authCode)
	EditText authCode;

	@InjectView(R.id.verifiedMobilePhone)
	TextView verifiedMobilePhone;

	private String strAuthCode;

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_forget_password);
		ButterKnife.inject(this);
		((TextView) ButterKnife.findById(this, R.id.actionBarTitle))
				.setText(R.string.forget_password_title);
	}

	@OnClick(value = { R.id.back, R.id.getAuthCode, R.id.confirm })
	void setClickEvent(View view) {
		switch(view.getId()) {
			case R.id.back:
				finish();
				break;
			case R.id.getAuthCode:
				getAuthCode();
				break;
			case R.id.confirm:
				changePassword();
				break;
		}
	}

	/**
	 * 获取短信验证码操作
	 */
	private void getAuthCode() {
		final String strMobilePhone = mobilePhone.getText().toString();
		if(strMobilePhone.length() == 0) {
			BaseApplication.toast("未输入手机号");
			return;
		} else if(strMobilePhone.length() < 11) {
			BaseApplication.toast("手机号未输入完整");
			return;
		} else if(!BaseApplication.isMobilePhone(strMobilePhone)) {
			BaseApplication.toast("不存在此手机号");
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
						BaseApplication.toast("获取验证码失败，请重试");
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
						BaseApplication.toast(strAuthCode);
						authCode.setText(strAuthCode);
						verifiedMobilePhone.setText("已验证手机：" + strMobilePhone);
					}
				});
			}
		});
	}

	/**
	 * 修改密码操作
	 */
	private void changePassword() {
		String strMobilePhone = mobilePhone.getText().toString();
		String strPassword = password.getText().toString();
		String strConfirmPassword = confirmPassword.getText().toString();
		String strAuthCode = authCode.getText().toString();

		if(strMobilePhone.length() == 0) {
			BaseApplication.toast("未输入手机号");
			return;
		} else if(strMobilePhone.length() < 11) {
			BaseApplication.toast("手机号未输入完整");
			return;
		} else if(!BaseApplication.isMobilePhone(strMobilePhone)) {
			BaseApplication.toast("不存在此手机号");
			return;
		} else if(strPassword.length() == 0 || strConfirmPassword.length() == 0) {
			BaseApplication.toast("未输入密码");
			return;
		} else if(strPassword.length() < 6 || strConfirmPassword.length() == 0) {
			BaseApplication.toast("密码未输入完整");
			return;
		} else if(!strPassword.equals(strConfirmPassword)) {
			BaseApplication.toast("两次输入的密码不一致");
			return;
		} else if(strAuthCode.length() == 0) {
			BaseApplication.toast("未输入短信验证码");
			return;
		} else if(!strAuthCode.equals(this.strAuthCode)) {
			BaseApplication.toast("短信验证码输入错误");
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
						BaseApplication.toast("修改密码失败，请重试");
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
								BaseApplication.toast("修改密码成功");
								finish();
								break;
							case "0":
								BaseApplication.toast("修改密码失败，请重试");
								break;
						}
					}
				});
			}
		});
	}
}
