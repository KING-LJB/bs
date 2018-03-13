package com.hncj.bs.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.ExtEproductDao;
import com.hncj.bs.domain.ExtEproduct;

@Repository //不加注解，无法扫描到该dao
public class ExtEproductDaoImpl extends BaseDaoImpl<ExtEproduct> implements ExtEproductDao{

	public ExtEproductDaoImpl() {
		//设置命名空间
		super.setNs("com.hncj.bs.mapper.ExtEproductMapper");
	}

	@Override
	public void deleteByExportProductById(Serializable[] ids) {
		super.getSqlSession().delete(super.getNs()+".deleteByExportProductById", ids);     //根据货物删除附件
		
	}

	@Override
	public void deleteByExportId(Serializable[] exportIds) {
		super.getSqlSession().delete(super.getNs()+".deleteByExportId", exportIds);             //根据合同删除附件
		
	}

	
}
