package com.hncj.bs.dao;

import java.util.Map;

import com.hncj.bs.domain.Contract;
import com.hncj.bs.vo.ContractVO;

// 继承baseDao里的所有的增删改查方法
public interface ContractDao extends BaseDao<Contract> {
	public void updateState(Map map);
	
	public ContractVO view(String contractId);     // 查询某个合同

}
