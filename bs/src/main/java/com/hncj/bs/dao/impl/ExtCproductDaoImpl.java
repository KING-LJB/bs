package com.hncj.bs.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.ExtCproductDao;
import com.hncj.bs.domain.ExtCproduct;

@Repository //不加注解，无法扫描到该dao
public class ExtCproductDaoImpl extends BaseDaoImpl<ExtCproduct> implements ExtCproductDao{

	public ExtCproductDaoImpl() {
		//设置命名空间
		super.setNs("com.hncj.bs.mapper.ExtCproductMapper");
	}

	@Override
	public void deleteByContractProductById(Serializable[] ids) {
		super.getSqlSession().delete(super.getNs()+".deleteByContractProductById", ids);     //根据货物删除附件
	}
	
	public void deleteByContractId(Serializable[] contractIds){
		super.getSqlSession().delete(super.getNs()+".deleteByContractId", contractIds);             //根据合同删除附件
	}
	
}
