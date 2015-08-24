package com.liuhui.ceremony.app.bean;

/**
 * 印象
 * <p/>
 * Created by berial on 15/8/24.
 */
public class Impression {
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
}
