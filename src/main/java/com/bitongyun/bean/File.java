package com.bitongyun.bean;

import java.util.Date;

public class File {
	private String file_name;
	private String file_url;
	private String user_name;
	private Date upload_time;
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_url() {
		return file_url;
	}
	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Date getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(Date upload_time) {
		this.upload_time = upload_time;
	}
	public File(String file_name, String file_url, String user_name, Date upload_time) {
		super();
		this.file_name = file_name;
		this.file_url = file_url;
		this.user_name = user_name;
		this.upload_time = upload_time;
	}
	public File() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
