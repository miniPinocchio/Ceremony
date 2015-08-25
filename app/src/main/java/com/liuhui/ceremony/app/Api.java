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
     * 情礼攻略
     */
    public static String GIFT = BASE_URL + "/index.php?s=appapi&a=idea";

    /**
     * 相册
     */
    public static String GRALLERY = BASE_URL + "/index.php?s=appapi&a=album";
}
