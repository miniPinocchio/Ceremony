package com.liuhui.ceremony.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * 应用App类
 * <p/>
 * Created by __Berial___
 */
public class BaseApplication extends Application {

	private static BaseApplication instance;

	private static String FIRST_OPEN_APP = "first_open_app.pref";
	public static Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		context = getApplicationContext();
	}

	public static BaseApplication getInstance() {
		return instance;
	}


	/**
	 * toast
	 */
	public static void toast(@NonNull CharSequence text) {
		Toast.makeText(instance, text, Toast.LENGTH_SHORT).show();
	}

	/**
	 * toast
	 */
	public static void toast(@StringRes int stringRes) {
		Toast.makeText(instance, stringRes, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 是否是手机号
	 */
	public static boolean isMobilePhone(String text) {
		String matcher = "^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8]))\\d{8}$";
		return text.matches(matcher);
	}
}
