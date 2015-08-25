package com.liuhui.ceremony.app.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.liuhui.ceremony.app.Api;
import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;
import com.liuhui.ceremony.app.bean.AuthCode;
import com.liuhui.ceremony.app.constant.RequestParam;
import com.liuhui.ceremony.app.util.OkHttpClientManager;
import com.squareup.okhttp.Request;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 更改手机
 * <p/>
 * Created by berial on 15/8/25.
 */
public class ChangeMobileActivity extends BaseActivity {

	@InjectView(R.id.mobilePhone)
	EditText mobilePhone;

	@InjectView(R.id.authCode)
	EditText authCode;

	@InjectView(R.id.verifiedMobilePhone)
	TextView verifiedMobilePhone;

	private String strAuthCode;

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_change_mobile);
		ButterKnife.inject(this);
		((TextView) ButterKnife.findById(this, R.id.actionBarTitle))
				.setText(R.string.change_mobile);
	}

	@OnClick({ R.id.back, R.id.getAuthCode, R.id.submit })
	void setClickEvent(View view) {
		switch(view.getId()) {
			case R.id.back:
				finish();
				break;
			case R.id.getAuthCode:
				getAuthCode();
				break;
			case R.id.submit:
				changeMobile();
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
	 * 更改手机
	 */
	private void changeMobile() {
		//TODO 待发布接口
	}
}
