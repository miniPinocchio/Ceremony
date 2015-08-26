package com.liuhui.ceremony.app.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 印象
 * <p/>
 * Created by berial on 15/8/24.
 */
public class Impression implements Parcelable {
	/**
	 * id : 11
	 * impress : 帅呆了
	 * impressnum : 5
	 */
	private String id;
	private String impress;
	private String impressnum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setImpress(String impress) { this.impress = impress;}

	public void setImpressnum(String impressnum) { this.impressnum = impressnum;}

	public String getImpress() { return impress;}

	public String getImpressnum() { return impressnum;}

	@Override
	public String toString() {
		return "Impression{" +
				"id='" + id + '\'' +
				", impress='" + impress + '\'' +
				", impressnum='" + impressnum + '\'' +
				'}';
	}

	@Override
	public int describeContents() { return 0; }

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.id);
		dest.writeString(this.impress);
		dest.writeString(this.impressnum);
	}

	public Impression() {}

	protected Impression(Parcel in) {
		this.id = in.readString();
		this.impress = in.readString();
		this.impressnum = in.readString();
	}

	public static final Parcelable.Creator<Impression> CREATOR = new Parcelable.Creator<Impression>() {
		public Impression createFromParcel(Parcel source) {return new Impression(source);}

		public Impression[] newArray(int size) {return new Impression[size];}
	};
}
