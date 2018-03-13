package com.hncj.bs.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.ContractDao;
import com.hncj.bs.domain.Contract;
import com.hncj.bs.vo.ContractVO;

@Repository //不加注解，无法扫描到该dao
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao{

	public ContractDaoImpl() {
		//设置命名空间
		super.setNs("com.hncj.bs.mapper.ContractMapper");
	}

	@Override
	public void updateState(Map map) {
		// TODO Auto-generated method stub
		super.getSqlSession().update(super.getNs()+".updateState", map);
	}

	@Override
	public ContractVO view(String contractId) {
		return super.getSqlSession().selectOne(super.getNs()+".view", contractId);
	}
	
	
}
