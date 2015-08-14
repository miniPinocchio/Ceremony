package com.liuhui.ceremony.app.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.liuhui.ceremony.app.AppManager;
import com.liuhui.ceremony.app.util.LogUtil;

import butterknife.ButterKnife;

/**
 * Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {

	private static final int ACTIVITY_RESUME = 0;
	private static final int ACTIVITY_STOP = 1;
	private static final int ACTIVITY_PAUSE = 2;
	private static final int ACTIVITY_DESTROY = 3;

	public int activityState;

	// 是否允许全屏
	private boolean mAllowFullScreen = true;

	/**
	 * 设置是否允许屏幕全屏
	 */
	public void setAllowFullScreen(boolean allowFullScreen) {
		this.mAllowFullScreen = allowFullScreen;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LogUtil.i("---------onCreate ");

		// 竖屏锁定
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		initViews();
		ButterKnife.inject(this);
		AppManager.getAppManager().addActivity(this);
	}

	/**
	 * 初始化布局：首行需要setContentView()
	 */
	protected abstract void initViews();

	@Override
	protected void onStart() {
		super.onStart();
		LogUtil.i("---------onStart ");
	}

	@Override
	protected void onResume() {
		super.onResume();
		LogUtil.i("---------onResume ");
	}

	@Override
	protected void onPause() {
		super.onPause();
		LogUtil.i("---------onPause ");
	}

	@Override
	protected void onStop() {
		super.onStop();
		LogUtil.i("---------onStop ");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		LogUtil.i("---------onDestroy ");
		AppManager.getAppManager().finishActivity(this);
	}
}
