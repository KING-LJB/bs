package com.hncj.bs.dao.impl;

import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.ContractHisDao;
import com.hncj.bs.domain.Contract;
import com.hncj.bs.vo.ContractVO;

@Repository //不加注解，无法扫描到该dao
public class ContractHisDaoImpl extends BaseDaoImpl<Contract> implements ContractHisDao{

	public ContractHisDaoImpl() {
		//设置命名空间
		super.setNs("com.hncj.bs.mapper.ContractHisMapper");
	}

	@Override
	public ContractVO view(String contractId) {
		return super.getSqlSession().selectOne(super.getNs()+".view", contractId);
	}
	
	
}
