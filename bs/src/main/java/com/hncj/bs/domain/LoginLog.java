package com.hncj.bs.domain;

import java.util.Date;

/**
 * 登录的日志信息
 * @author Administrator
 *
 */
public class LoginLog {

	private String id;
	private String loginname;    // 登录者姓名
	private String ipaddress;     // 登录的ip地址
	private Date logintime;      // 登录的时间
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public Date getLogintime() {
		return logintime;
	}
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
	
	
}
