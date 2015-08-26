package com.liuhui.ceremony.app.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 用户
 * <p/>
 * Created by berial on 15/8/24.
 */
public class User implements Parcelable {
	/**
	 * sex : 1
	 * address : 北京市朝阳区东四大街
	 * nickname : 大兵
	 * month : 05
	 * userid : 2
	 * year : 1988
	 * day : 02
	 * avatar : /4/U_dl940.jpg
	 * mobile : 18007770951
	 */
	private String sex;
	private String address;
	private String nickname;
	private String month;
	private String userid;
	private String year;
	private String day;
	private String avatar;
	private String mobile;
	private String xingzuo;

	public void setSex(String sex) { this.sex = sex;}

	public void setAddress(String address) { this.address = address;}

	public void setNickname(String nickname) { this.nickname = nickname;}

	public void setMonth(String month) { this.month = month;}

	public void setUserid(String userid) { this.userid = userid;}

	public void setYear(String year) { this.year = year;}

	public void setDay(String day) { this.day = day;}

	public void setAvatar(String avatar) { this.avatar = avatar;}

	public void setMobile(String mobile) { this.mobile = mobile;}

	public String getSex() { return sex;}

	public String getAddress() { return address;}

	public String getNickname() { return nickname;}

	public String getMonth() { return month;}

	public String getUserid() { return userid;}

	public String getYear() { return year;}

	public String getDay() { return day;}

	public String getAvatar() { return avatar;}

	public String getMobile() { return mobile;}

	public String getXingzuo() {
		return xingzuo;
	}

	public void setXingzuo(String xingzuo) {
		this.xingzuo = xingzuo;
	}

	@Override
	public String toString() {
		return "User{" +
				"sex='" + sex + '\'' +
				", address='" + address + '\'' +
				", nickname='" + nickname + '\'' +
				", month='" + month + '\'' +
				", userid='" + userid + '\'' +
				", year='" + year + '\'' +
				", day='" + day + '\'' +
				", avatar='" + avatar + '\'' +
				", mobile='" + mobile + '\'' +
				", xingzuo='" + xingzuo + '\'' +
				'}';
	}

	@Override
	public int describeContents() { return 0; }

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.sex);
		dest.writeString(this.address);
		dest.writeString(this.nickname);
		dest.writeString(this.month);
		dest.writeString(this.userid);
		dest.writeString(this.year);
		dest.writeString(this.day);
		dest.writeString(this.avatar);
		dest.writeString(this.mobile);
		dest.writeString(this.xingzuo);
	}

	public User() {}

	protected User(Parcel in) {
		this.sex = in.readString();
		this.address = in.readString();
		this.nickname = in.readString();
		this.month = in.readString();
		this.userid = in.readString();
		this.year = in.readString();
		this.day = in.readString();
		this.avatar = in.readString();
		this.mobile = in.readString();
		this.xingzuo = in.readString();
	}

	public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
		public User createFromParcel(Parcel source) {return new User(source);}

		public User[] newArray(int size) {return new User[size];}
	};
}
