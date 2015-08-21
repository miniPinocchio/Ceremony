package com.liuhui.ceremony.app.bean;

/**
 * 登录响应
 * <p/>
 * Created by berial on 15/8/21.
 */
public class LoginResponseBody extends ResponseBody {

	private String userid;
	private String mobile;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
