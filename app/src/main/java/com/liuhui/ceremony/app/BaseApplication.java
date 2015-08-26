package com.liuhui.ceremony.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.liuhui.ceremony.app.util.LogUtil;
import com.liuhui.ceremony.app.util.OkHttpClientManager;

import java.io.InputStream;

/**
 * 应用App类
 * <p/>
 * Created by __Berial___
 */
public class BaseApplication extends Application {

	private static final String APP_CONFIG = "appConfig";

	private static final String USER_ID = "userId";

	private static BaseApplication instance;

	public static Context context;

	private static String mUserId;

	private static int count;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		context = getApplicationContext();

		Glide.get(this).register(GlideUrl.class, InputStream.class,
				new OkHttpUrlLoader.Factory(OkHttpClientManager.getInstance()
						.getOkHttpClient()));
	}

	public static BaseApplication getInstance() {
		return instance;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		BaseApplication.count = count;
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

	/**
	 * 得到用户id
	 */
	public static String getUserId() {
		SharedPreferences sp = instance.getSharedPreferences(APP_CONFIG,
				Context.MODE_PRIVATE);
		if(TextUtils.isEmpty(mUserId)) {
			mUserId = sp.getString(USER_ID, "");
		}
		return mUserId;
	}

	/**
	 * 保存用户id
	 */
	public static void setUserId(String userId) {
		instance.getSharedPreferences(APP_CONFIG, Context.MODE_PRIVATE)
				.edit().putString(USER_ID, userId).commit();
		mUserId = userId;
		LogUtil.e("userId -> " + userId);
	}

}
