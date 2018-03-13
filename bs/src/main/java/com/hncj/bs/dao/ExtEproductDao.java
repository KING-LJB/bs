package com.hncj.bs.dao;

import java.io.Serializable;

import com.hncj.bs.domain.ExtEproduct;

// 继承baseDao里的所有的增删改查方法
public interface ExtEproductDao extends BaseDao<ExtEproduct> {
	public void deleteByExportProductById(Serializable[] ids);

	public void deleteByExportId(Serializable[] exportIds);
}
