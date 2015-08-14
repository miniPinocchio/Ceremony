package com.liuhui.ceremony.app.activity;

import android.content.Intent;
import android.os.Handler;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;

/**
 * 启动界面
 */
public class SplashActivity extends BaseActivity {

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_splash);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				startActivity(new Intent(SplashActivity.this, LoginActivity.class));
				finish();
			}
		}, 2000);
	}
}
