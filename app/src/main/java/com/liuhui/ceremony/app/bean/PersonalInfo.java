package com.liuhui.ceremony.app.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 个人信息
 * <p/>
 * Created by berial on 15/8/24.
 */
public class PersonalInfo implements Parcelable {

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

	@Override
	public int describeContents() { return 0; }

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeTypedList(userinfo);
		dest.writeTypedList(impresslist);
		dest.writeTypedList(xzlist);
	}

	public PersonalInfo() {}

	protected PersonalInfo(Parcel in) {
		this.userinfo = in.createTypedArrayList(User.CREATOR);
		this.impresslist = in.createTypedArrayList(Impression.CREATOR);
		this.xzlist = in.createTypedArrayList(Constellation.CREATOR);
	}

	public static final Parcelable.Creator<PersonalInfo> CREATOR = new Parcelable.Creator<PersonalInfo>() {
		public PersonalInfo createFromParcel(Parcel source) {return new PersonalInfo(source);}

		public PersonalInfo[] newArray(int size) {return new PersonalInfo[size];}
	};
}
