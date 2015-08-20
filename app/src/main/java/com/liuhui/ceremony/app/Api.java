package com.liuhui.ceremony.app;

/**
 * App中使用的接口
 * <p/>
 * Created by __Berial___
 */
public class Api {

	/**
	 * 基础请求地址
	 */
	public static String BASEURL = "http://xl.wx.21future.com";

	/**
	 * 登录 POST
	 */
	public static String LOGIN = "http://xl.wx.21future.com/index.php?s=appapi&a=login";

	/**
	 * 获取短信验证码 POST
	 */
	public static String GET_AUTH_CODE = "http://xl.wx.21future.com/index.php?s=appapi&a=pin";

	/**
	 * 注册 POST
	 */
	public static String REGISTER = "http://xl.wx.21future.com/index.php?s=appapi&a=reg";
}
