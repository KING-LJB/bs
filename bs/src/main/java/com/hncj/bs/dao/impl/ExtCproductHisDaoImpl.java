package com.hncj.bs.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.ExtCproductHisDao;
import com.hncj.bs.domain.ExtCproduct;

@Repository //不加注解，无法扫描到该dao
public class ExtCproductHisDaoImpl extends BaseDaoImpl<ExtCproduct> implements ExtCproductHisDao{

	public ExtCproductHisDaoImpl() {
		//设置命名空间
		super.setNs("com.hncj.bs.mapper.ExtCproductHisMapper");
	}

	@Override
	public void deleteByContractProductHisById(Serializable[] ids) {
		super.getSqlSession().delete(super.getNs()+".deleteByContractProductHisById", ids);     //根据货物删除附件
	}
	
	public void deleteByContractHisId(Serializable[] contractIds){
		super.getSqlSession().delete(super.getNs()+".deleteByContractHisId", contractIds);             //根据合同删除附件
	}
	
}
