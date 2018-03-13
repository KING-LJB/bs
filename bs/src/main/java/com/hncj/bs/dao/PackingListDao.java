package com.hncj.bs.dao;

import java.util.Map;

import com.hncj.bs.domain.PackingList;

// 继承baseDao里的所有的增删改查方法
public interface PackingListDao extends BaseDao<PackingList> {
	public void updateState(Map map);
	

}
