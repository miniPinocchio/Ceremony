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

	@OnClick({ R.id.back, R.id.getAuthCode, R.id.confirm })
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
						verifiedMobilePhone.setText("已验证手机：" + strMobilePhone);
					}
				},
				new OkHttpClientManager.Param(RequestParam.MOBILE, strMobilePhone));
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

		//TODO 接口待定
		OkHttpClientManager.postAsyn(Api.REGISTER, new OkHttpClientManager.ResultCallback<ResponseBody>() {

					@Override
					public void onError(Request request, Exception e) {
						BaseApplication.toast("修改密码失败，请重试");
					}

					@Override
					public void onResponse(ResponseBody response) {
						switch(response.getStatus()) {
							case "1":
								BaseApplication.toast("修改密码成功");
								finish();
								break;
							case "0":
								BaseApplication.toast("修改密码失败，请重试");
								break;
						}
					}
				},
				new OkHttpClientManager.Param(RequestParam.MOBILE, strMobilePhone),
				new OkHttpClientManager.Param(RequestParam.PASSWORD, strPassword),
				new OkHttpClientManager.Param(RequestParam.AUTH_CODE, strAuthCode));
	}
}
