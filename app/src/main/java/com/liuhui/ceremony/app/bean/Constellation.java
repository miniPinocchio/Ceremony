package com.liuhui.ceremony.app.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 星座
 * <p/>
 * Created by berial on 15/8/24.
 */
public class Constellation implements Parcelable {
	/**
	 * id : 1
	 * name : 魔羯座
	 */
	private String id;
	private String name;

	public void setId(String id) { this.id = id;}

	public void setName(String name) { this.name = name;}

	public String getId() { return id;}

	public String getName() { return name;}

	@Override
	public String toString() {
		return "Constellation{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}

	@Override
	public int describeContents() { return 0; }

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.id);
		dest.writeString(this.name);
	}

	public Constellation() {}

	protected Constellation(Parcel in) {
		this.id = in.readString();
		this.name = in.readString();
	}

	public static final Parcelable.Creator<Constellation> CREATOR = new Parcelable.Creator<Constellation>() {
		public Constellation createFromParcel(Parcel source) {return new Constellation(source);}

		public Constellation[] newArray(int size) {return new Constellation[size];}
	};
}
