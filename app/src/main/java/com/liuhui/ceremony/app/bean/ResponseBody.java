package com.liuhui.ceremony.app.bean;

/**
 * 服务器响应
 * <p></>
 * Created by berial on 15/8/14.
 */
public class ResponseBody {

	private String status;
	private String data;

	public void setStatus(String status) { this.status = status;}

	public void setData(String data) { this.data = data;}

	public String getStatus() { return status;}

	public String getData() { return data;}
}
