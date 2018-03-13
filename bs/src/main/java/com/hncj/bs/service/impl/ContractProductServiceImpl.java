package com.hncj.bs.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hncj.bs.dao.ContractProductDao;
import com.hncj.bs.dao.ExtCproductDao;
import com.hncj.bs.domain.ContractProduct;
import com.hncj.bs.pagination.Page;
import com.hncj.bs.service.ContractProductService;
import com.hncj.util.UtilFuns;

@Service
public class ContractProductServiceImpl implements ContractProductService {

	@Resource
	ContractProductDao contractProductDao;
	
	@Resource
	ExtCproductDao extCproductDao;
	
	@Override
	public List<ContractProduct> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContractProduct> find(Map paraMap) {
		return contractProductDao.find(paraMap);
	}

	@Override
	public ContractProduct get(Serializable id) {
		return contractProductDao.get(id);
	}

	@Override
	public void insert(ContractProduct contractProduct) {
		contractProduct.setId(UUID.randomUUID().toString());
		// 自动计算总金额=数量*单价                                     ...修改，删除；同步合同总金额
		if(UtilFuns.isNotEmpty(contractProduct.getCnumber()) && UtilFuns.isNotEmpty(contractProduct.getPrice())){
		contractProduct.setAmount(contractProduct.getCnumber() * contractProduct.getPrice());
		}
		
		contractProductDao.insert(contractProduct);
	}

	@Override
	public void update(ContractProduct contract) {
		contractProductDao.update(contract);
	}

	@Override
	public void deleteById(Serializable id) {
		Serializable[] ids = {id};
		extCproductDao.deleteByContractProductById(ids);    // 删除当前货物下的所有附件
		contractProductDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		extCproductDao.deleteByContractProductById(ids);    // 删除当前货物下的所有附件
		contractProductDao.delete(ids);
	}


}
