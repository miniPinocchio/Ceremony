package com.liuhui.ceremony.app.util;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * OkHttp封装的工具类
 * <p/>
 * Created by berial on 15/8/14.
 */
public final class OkHttpUtil {

	private static final OkHttpClient mOkHttpClient = new OkHttpClient();

	private OkHttpUtil() {}

	static {
		mOkHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);
	}

	/**
	 * 开启异步线程访问网络
	 */
	public static void enqueue(Request request, Callback responseCallback) {
		mOkHttpClient.newCall(request).enqueue(responseCallback);
	}

	/**
	 * 开启异步线程访问网络, 且不在意返回结果（实现空callback）
	 */
	public static void enqueue(Request request) {
		mOkHttpClient.newCall(request).enqueue(new Callback() {

			@Override
			public void onResponse(Response arg0) throws IOException {}

			@Override
			public void onFailure(Request arg0, IOException arg1) {}

		});
	}

}
