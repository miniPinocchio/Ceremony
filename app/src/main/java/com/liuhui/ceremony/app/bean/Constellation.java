package com.liuhui.ceremony.app.bean;

/**
 * 星座
 * <p/>
 * Created by berial on 15/8/24.
 */
public class Constellation {
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
}
