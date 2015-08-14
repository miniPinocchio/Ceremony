package com.liuhui.ceremony.app;

import android.app.Application;

/**
 * 应用App类
 */
public class App extends Application {

	private static App instance;

	private static String FIRST_OPEN_APP = "first_open_app.pref";

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}

	public static App getInstance(){
		return instance;
	}
}
