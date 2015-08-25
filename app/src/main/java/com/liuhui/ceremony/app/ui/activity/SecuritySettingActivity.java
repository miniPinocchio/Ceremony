package com.liuhui.ceremony.app.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 安全设置界面
 * <p/>
 * Created by berial on 15/8/21.
 */
public class SecuritySettingActivity extends BaseActivity {

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_security_setting);
		ButterKnife.inject(this);
		((TextView) ButterKnife.findById(this, R.id.actionBarTitle))
				.setText(R.string.security_setting);
	}

	/**
	 * 设置点击事件
	 */
	@OnClick({ R.id.back, R.id.changeMobile, R.id.bindEmail, R.id.changePassword,
			R.id.bindWeiBo, R.id.bindWeiXin })
	void setClickEvent(View view) {
		switch(view.getId()) {
			case R.id.back:
				finish();
				break;
			case R.id.changeMobile:
				startActivity(new Intent(this, ChangeMobileActivity.class));
				break;
			case R.id.bindEmail:
				break;
			case R.id.changePassword:
				break;
			case R.id.bindWeiBo:
				break;
			case R.id.bindWeiXin:
				break;
		}
	}
}
