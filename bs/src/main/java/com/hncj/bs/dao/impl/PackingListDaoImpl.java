package com.hncj.bs.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.PackingListDao;
import com.hncj.bs.domain.PackingList;

@Repository //不加注解，无法扫描到该dao
public class PackingListDaoImpl extends BaseDaoImpl<PackingList> implements PackingListDao{

	public PackingListDaoImpl() {
		//设置命名空间
		super.setNs("com.hncj.bs.mapper.PackingListMapper");
	}

	@Override
	public void updateState(Map map) {
		// TODO Auto-generated method stub
		super.getSqlSession().update(super.getNs()+".updateState", map);
	}

	
	
}
