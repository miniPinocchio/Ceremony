package com.liuhui.ceremony.app.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.liuhui.ceremony.app.Api;
import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;
import com.liuhui.ceremony.app.bean.AuthCode;
import com.liuhui.ceremony.app.bean.ResponseBody;
import com.liuhui.ceremony.app.constant.RequestParam;
import com.liuhui.ceremony.app.util.OkHttpClientManager;
import com.squareup.okhttp.Request;

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
		((TextView) ButterKnife.findById(this, R.id.actionBarTitle)).setText(R.string.register_title);
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
			BaseApplication.toast("未输入手机号");
			return;
		} else if(strMobilePhone.length() < 11) {
			BaseApplication.toast("手机号未输入完整");
			return;
		} else if(!BaseApplication.isMobilePhone(strMobilePhone)) {
			BaseApplication.toast("不存在此手机号");
			return;
		}

		OkHttpClientManager.postAsyn(Api.GET_AUTH_CODE, new OkHttpClientManager.ResultCallback<AuthCode>() {

					@Override
					public void onError(Request request, Exception e) {
						BaseApplication.toast("获取验证码失败，请重试");
					}

					@Override
					public void onResponse(AuthCode response) {
						strAuthCode = response.getPincode();
						BaseApplication.toast(strAuthCode);
						authCode.setText(strAuthCode);
					}
				},
				new OkHttpClientManager.Param(RequestParam.MOBILE, strMobilePhone));
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

		OkHttpClientManager.postAsyn(Api.REGISTER, new OkHttpClientManager.ResultCallback<ResponseBody>() {

					@Override
					public void onError(Request request, Exception e) {
						BaseApplication.toast("注册失败，请重试");
					}

					@Override
					public void onResponse(ResponseBody response) {
						switch(response.getStatus()) {
							case "1":
								BaseApplication.toast("注册成功");
								finish();
								break;
							case "0":
								BaseApplication.toast("注册失败，请重试");
								break;
						}
					}
				},
				new OkHttpClientManager.Param(RequestParam.MOBILE, strMobilePhone),
				new OkHttpClientManager.Param(RequestParam.PASSWORD, strPassword),
				new OkHttpClientManager.Param(RequestParam.AUTH_CODE, strAuthCode));
	}
}
