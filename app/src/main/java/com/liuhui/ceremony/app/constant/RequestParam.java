package com.liuhui.ceremony.app.constant;

/**
 * POST提交所用到的参数名
 * <p/>
 * Created by berial on 15/8/14.
 */
public interface RequestParam {

	/**
	 * 手机号
	 * 所用场景：登录、注册、手机验证、安全设置
	 */
	String MOBILE = "mobile";

	/**
	 * 密码
	 * 所用场景：登录、注册、安全设置
	 */
	String PASSWORD = "password";

	/**
	 * 短信验证码
	 * 所用场景：注册
	 */
	String AUTH_CODE = "pincode";
}
