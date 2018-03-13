package com.hncj.bs.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.FactoryDao;
import com.hncj.bs.domain.Factory;

@Repository //不加注解，无法扫描到该dao
public class FactoryDaoImpl extends BaseDaoImpl<Factory> implements FactoryDao{

	public FactoryDaoImpl() {
		//设置命名空间
		super.setNs("com.hncj.bs.mapper.FactoryMapper");
	}

	@Override
	public void updateState(Map map) {
		// TODO Auto-generated method stub
		super.getSqlSession().update(super.getNs()+".updateState", map);
	}
	
	
}
