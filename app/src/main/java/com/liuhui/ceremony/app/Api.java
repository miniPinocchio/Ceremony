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
	public static final String BASE_URL = "http://xl.wx.21future.com";

	/**
	 * 登录 POST
	 */
	public static final String LOGIN = BASE_URL + "/index.php?s=appapi&a=login";

	/**
	 * 获取短信验证码 POST
	 */
	public static final String GET_AUTH_CODE = BASE_URL + "/index.php?s=appapi&a=pin";

	/**
	 * 注册 POST
	 */
	public static final String REGISTER = BASE_URL + "/index.php?s=appapi&a=reg";

	/**
	 * 个人信息 POST
	 */
	public static final String PERSONAL_INFO = BASE_URL + "/index.php?s=appapi&a=profile";

	/**
	 * 编辑个人信息 POST
	 */
	public static final String EDIT_PERSONAL_INFO = BASE_URL + "/index.php?s=appapi&a=editprofile";

	/**
	 * 相册
	 */
	public static final String GALLERY = BASE_URL + "/index.php?s=appapi&a=album";

	/**
	 * 短信模板【祝福语】
	 */
	public static final String MSG_TEMPLATE = BASE_URL + "/index.php?s=appapi&a=bless";
	/**
	 * 情礼攻略
	 */
	public static final String GIFT = BASE_URL + "/index.php?s=appapi&a=idea";

	/**
	 * 打分
	 */
	public static final String GRADE = BASE_URL + "/index.php?s=appapi&a=grade";

}
