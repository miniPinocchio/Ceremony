package com.liuhui.ceremony.app.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.liuhui.ceremony.app.Api;
import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;
import com.liuhui.ceremony.app.bean.PersonalInfo;
import com.liuhui.ceremony.app.constant.RequestParam;
import com.liuhui.ceremony.app.util.LogUtil;
import com.liuhui.ceremony.app.util.OkHttpClientManager;
import com.squareup.okhttp.Request;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人信息
 * <p/>
 * Created by berial on 15/8/21.
 */
public class PersonalInfoActivity extends BaseActivity {

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_personal_info);
		ButterKnife.inject(this);
		((TextView) ButterKnife.findById(this, R.id.actionBarTitle))
				.setText(R.string.personal_info_title);
	}

	@Override
	protected void initData() {
		OkHttpClientManager.postAsyn(Api.PERSONAL_INFO, new OkHttpClientManager
						.ResultCallback<PersonalInfo>() {

					@Override
					public void onError(Request request, Exception e) {

					}

					@Override
					public void onResponse(PersonalInfo response) {
						LogUtil.e(response.toString());
					}
				},
				new OkHttpClientManager.Param(RequestParam.UID, BaseApplication.getUserId()));
	}

	/**
	 * 设置点击事件
	 */
	@OnClick({ R.id.back })
	void setClickEvent(View view) {
		switch(view.getId()) {
			case R.id.back:
				finish();
				break;
		}
	}
}
