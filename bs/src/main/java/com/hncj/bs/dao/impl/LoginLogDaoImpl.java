package com.hncj.bs.dao.impl;


import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.LoginLogDao;
import com.hncj.bs.domain.LoginLog;

@Repository //不加注解，无法扫描到该dao
public class LoginLogDaoImpl extends BaseDaoImpl<LoginLog> implements LoginLogDao{

	public LoginLogDaoImpl() {
		//设置命名空间
		super.setNs("com.hncj.bs.mapper.LoginLogMapper");
	}

	
	
}
