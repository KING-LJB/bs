package com.hncj.bs.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.ExportDao;
import com.hncj.bs.domain.Export;

@Repository //不加注解，无法扫描到该dao
public class ExportDaoImpl extends BaseDaoImpl<Export> implements ExportDao{

	public ExportDaoImpl() {
		//设置命名空间
		super.setNs("com.hncj.bs.mapper.ExportMapper");
	}

	@Override
	public void updateState(Map map) {
		// TODO Auto-generated method stub
		super.getSqlSession().update(super.getNs()+".updateState", map);
	}

}
