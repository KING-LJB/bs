package com.hncj.bs.dao;

import java.util.Map;

import com.hncj.bs.domain.Export;

// 继承baseDao里的所有的增删改查方法
public interface ExportDao extends BaseDao<Export> {
	public void updateState(Map map);
	
}
