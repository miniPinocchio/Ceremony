package com.liuhui.ceremony.app.bean;

import java.util.List;

/**
 * 打分记录
 * <p/>
 * Created by berial on 15/8/27.
 */
public class GradeRecord {

	List<GradeUser> list;

	public List<GradeUser> getList() {
		return list;
	}

	public void setList(List<GradeUser> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "GradeRecord{" +
				"list=" + list +
				'}';
	}
}
