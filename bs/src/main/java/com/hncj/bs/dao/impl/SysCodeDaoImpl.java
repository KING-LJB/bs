package com.hncj.bs.dao.impl;


import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.SysCodeDao;
import com.hncj.bs.domain.SysCode;

@Repository //不加注解，无法扫描到该dao
public class SysCodeDaoImpl extends BaseDaoImpl<SysCode> implements SysCodeDao{

	public SysCodeDaoImpl() {
		//设置命名空间
		super.setNs("com.hncj.bs.mapper.SysCodeMapper");
	}

	
}
