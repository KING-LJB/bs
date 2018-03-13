package com.hncj.bs.dao;


import java.io.Serializable;

import com.hncj.bs.domain.ExportProduct;

// 继承baseDao里的所有的增删改查方法
public interface ExportProductDao extends BaseDao<ExportProduct> {

	public void deleteByExportId(Serializable[] ids);
}
