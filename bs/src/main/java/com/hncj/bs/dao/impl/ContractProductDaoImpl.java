package com.hncj.bs.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.ContractProductDao;
import com.hncj.bs.domain.ContractProduct;

@Repository //不加注解，无法扫描到该dao
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao{

	public ContractProductDaoImpl() {
		//设置命名空间
		super.setNs("com.hncj.bs.mapper.ContractProductMapper");
	}

//	@Override
//	public void deleteByContractProductById(Serializable[] ids) {
//		super.getSqlSession().delete(super.getNs()+".deleteByContractProductById", ids);     //根据货物删除附件
//		
//	}

	public void deleteByContractId(Serializable[] ids){
		super.getSqlSession().delete(super.getNs()+".deleteByContractId", ids);              //删除合同下的货物
	}

	
	
}
