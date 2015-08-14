package com.liuhui.ceremony.app;

/**
 * App中使用的接口
 * <p/>
 * Created by __Berial___
 */
public interface Api {

	/**
	 * 登录 POST
	 */
	String LOGIN = "http://xl.wx.21future.com/index.php?s=appapi&a=login";

	/**
	 * 获取短信验证码 POST
	 */
	String GET_AUTH_CODE = "http://xl.wx.21future.com/index.php?s=appapi&a=pin";

	/**
	 * 注册 POST
	 */
	String REGISTER = "http://xl.wx.21future.com/index.php?s=appapi&a=reg";
}
