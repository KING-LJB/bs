package com.hncj.bs.dao;

import java.io.Serializable;

import com.hncj.bs.domain.ContractProduct;

// 继承baseDao里的所有的增删改查方法
public interface ContractProductDao extends BaseDao<ContractProduct> {
//	public void deleteByContractProductById(Serializable[] ids);
	
	public void deleteByContractId(Serializable[] ids);

}
