package com.hncj.bs.dao.impl;


import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.LogDao;
import com.hncj.bs.domain.Log;

@Repository //不加注解，无法扫描到该dao
public class LogDaoImpl extends BaseDaoImpl<Log> implements LogDao{

	public LogDaoImpl() {
		//设置命名空间
		super.setNs("com.hncj.bs.mapper.LogMapper");
	}

	
	
}
