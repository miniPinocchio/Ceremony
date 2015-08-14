package com.liuhui.ceremony.app.ui.activity;

import android.content.Intent;
import android.os.Handler;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;
import com.liuhui.ceremony.app.ui.fragment.LoginFragment;

/**
 * 启动界面
 * <p/>
 * Created by __Berial___
 */
public class SplashActivity extends BaseActivity {

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_splash);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				startActivity(new Intent(SplashActivity.this, LoginFragment.class));
				finish();
			}
		}, 2000);
	}
}
