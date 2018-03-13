package com.hncj.bs.dao;

import java.util.Map;

import com.hncj.bs.domain.Factory;

// 继承baseDao里的所有的增删改查方法
public interface FactoryDao extends BaseDao<Factory> {
	public void updateState(Map map);

}
