package com.job5156.jsDateJoin.entity;

import com.job5156.framework.dao.AbstractBaseEntity;

public class test2 extends AbstractBaseEntity {
	private String username;
	private String password;
	private int tid;
	private String url;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
