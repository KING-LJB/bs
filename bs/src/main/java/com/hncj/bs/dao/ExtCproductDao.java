package com.hncj.bs.dao;

import java.io.Serializable;

import com.hncj.bs.domain.ExtCproduct;

// 继承baseDao里的所有的增删改查方法
public interface ExtCproductDao extends BaseDao<ExtCproduct> {
	public void deleteByContractProductById(Serializable[] ids);

	public void deleteByContractId(Serializable[] contractIds);
	
}
