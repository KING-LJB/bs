package com.hncj.bs.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.ExportProductDao;
import com.hncj.bs.domain.ExportProduct;

@Repository //不加注解，无法扫描到该dao
public class ExportProductDaoImpl extends BaseDaoImpl<ExportProduct> implements ExportProductDao{

	public ExportProductDaoImpl() {
		//设置命名空间
		super.setNs("com.hncj.bs.mapper.ExportProductMapper");
	}

	@Override
	public void deleteByExportId(Serializable[] ids) {
		super.getSqlSession().delete(super.getNs()+".deleteByExportId", ids);              //删除合同下的货物
	}


	
	
}
