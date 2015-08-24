package com.liuhui.ceremony.app.bean;

import java.util.List;

/**
 * 个人信息
 * <p/>
 * Created by berial on 15/8/24.
 */
public class PersonalInfo {

	private List<User> userinfo;
	private List<Impression> impresslist;
	private List<Constellation> xzlist;

	public List<User> getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(List<User> userinfo) {
		this.userinfo = userinfo;
	}

	public List<Impression> getImpresslist() {
		return impresslist;
	}

	public void setImpresslist(List<Impression> impresslist) {
		this.impresslist = impresslist;
	}

	public List<Constellation> getXzlist() {
		return xzlist;
	}

	public void setXzlist(List<Constellation> xzlist) {
		this.xzlist = xzlist;
	}

	@Override
	public String toString() {
		return "PersonalInfo{" +
				"userinfo=" + userinfo +
				", impresslist=" + impresslist +
				", xzlist=" + xzlist +
				'}';
	}
}
