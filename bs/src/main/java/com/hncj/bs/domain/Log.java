package com.hncj.bs.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 主页介绍信息
 * @author Administrator
 *
 */
public class Log {
	private String id;
	private Date logtime;        //主页标签时间
	private String logtext;      //主页标签内容
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getLogtime() {
		return logtime;
	}
	
//	@DateTimeFormat(pattern="yy-MM-dd HH:mm:ss")
	public void setLogtime(Date logtime) {
		this.logtime = logtime;
	}
	public String getLogtext() {
		return logtext;
	}
	public void setLogtext(String logtext) {
		this.logtext = logtext;
	}
	
}
