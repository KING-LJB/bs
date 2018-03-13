package com.hncj.bs.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hncj.bs.dao.ContractDao;
import com.hncj.bs.dao.ContractProductDao;
import com.hncj.bs.dao.ExtCproductDao;
import com.hncj.bs.domain.Contract;
import com.hncj.bs.pagination.Page;
import com.hncj.bs.service.ContractService;
import com.hncj.bs.vo.ContractVO;

@Service
public class ContractServiceImpl implements ContractService {

	@Resource
	ContractDao contractDao;
	
	@Resource
	ContractProductDao contractProductDao;
	
	@Resource
	ExtCproductDao extCproductDao;
	
	@Override
	public List<Contract> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contract> find(Map paraMap) {
		return contractDao.find(paraMap);
	}

	@Override
	public Contract get(Serializable id) {
		return contractDao.get(id);
	}

	@Override
	public void insert(Contract contract) {
		contract.setId(UUID.randomUUID().toString());
		contract.setState(0);            // 0 草稿  1 已上报
		contractDao.insert(contract);
	}

	@Override
	public void update(Contract contract) {
		contractDao.update(contract);
	}

	@Override
	public void deleteById(Serializable id) {
		Serializable[] ids = {id};
		extCproductDao.deleteByContractId(ids);                // 删除当前合同下的附件信息
		contractProductDao.deleteByContractId(ids);            // 删除当前合同下的货物信息
		contractDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		extCproductDao.deleteByContractId(ids);               // 删除当前合同下的附件信息
		contractProductDao.deleteByContractId(ids);           // 删除当前合同下的货物信息
		contractDao.delete(ids);
	}

	@Override
	public void submit(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 1);            // 1 已上报
		map.put("ids", ids);
		
		contractDao.updateState(map);
	}

	@Override
	public void cancel(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 0);           // 0 草稿
		map.put("ids", ids);
		
		contractDao.updateState(map);
	}

	@Override
	public ContractVO view(String contractId) {
		return contractDao.view(contractId);
	}

}
