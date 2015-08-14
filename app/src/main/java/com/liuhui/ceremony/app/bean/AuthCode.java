package com.liuhui.ceremony.app.bean;

/**
 * 短信验证码
 * <p/>
 * Created by berial on 15/8/14.
 */
public class AuthCode {

	private String pincode;
	private String optime;

	public void setPincode(String pincode) { this.pincode = pincode;}

	public void setOptime(String optime) { this.optime = optime;}

	public String getPincode() { return pincode;}

	public String getOptime() { return optime;}
}
