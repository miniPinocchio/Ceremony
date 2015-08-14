package com.liuhui.ceremony.app;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * 应用App类
 * <p/>
 * Created by __Berial___
 */
public class App extends Application {

	private static App instance;

	private static String FIRST_OPEN_APP = "first_open_app.pref";

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}

	public static App getInstance() {
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
