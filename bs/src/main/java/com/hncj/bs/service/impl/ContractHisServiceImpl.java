package com.hncj.bs.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hncj.bs.dao.ContractHisDao;
import com.hncj.bs.dao.ContractProductHisDao;
import com.hncj.bs.dao.ExtCproductHisDao;
import com.hncj.bs.domain.Contract;
import com.hncj.bs.pagination.Page;
import com.hncj.bs.service.ContractHisService;
import com.hncj.bs.vo.ContractVO;
import com.hncj.common.springdao.SqlDao;
import com.hncj.util.UtilFuns;

@Service
public class ContractHisServiceImpl implements ContractHisService {

	@Resource
	ContractHisDao contractHisDao;
	
	@Resource
	SqlDao sqlDao;
	
	@Resource
	ContractProductHisDao contractProductHisDao;
	
	@Resource
	ExtCproductHisDao extCproductHisDao;
	
	public void pigeinhole(String[] contractIds) {
		sqlDao.batchSQL(this.doData(contractIds, "", "_his"));		//批量执行                   操作合同表，货物表，附件表向对应的历史表操作
	}
	
	public void pigeouthole(String[] contractIds) {
		sqlDao.batchSQL(this.doData(contractIds, "_his", ""));      //批量执行                     操作历史表向对应合同表，货物表，附件表的操作
	}
	
	//处理数据：有源表向目标表复制数据，将源表数据删除
		public String[] doData(String[] contractIds, String source, String target){
			StringBuffer sBuf = new StringBuffer();
			String inStr = UtilFuns.joinStr(contractIds, "'", "'", ",");			//合同的id串 x,y ，构造成in子查询串 'x','y'
			
			sBuf.append("insert into contract").append(target).append("_c (select * from contract").append(source).append("_c where contract_id in (").append(inStr).append("));");
			sBuf.append("insert into contract_product").append(target).append("_c (select * from contract_product").append(source).append("_c where contract_id in (").append(inStr).append("));");
			sBuf.append("insert into ext_cproduct").append(target).append("_c (select * from ext_cproduct").append(source).append("_c where contract_product_id in (select contract_product_id from contract_product").append(source).append("_c where contract_id in (").append(inStr).append(")));");
			
			sBuf.append("delete from ext_cproduct").append(source).append("_c where contract_product_id in (select contract_product_id from contract_product").append(source).append("_c where contract_id in (").append(inStr).append("));");
			sBuf.append("delete from contract_product").append(source).append("_c where contract_id in (").append(inStr).append(");");
			sBuf.append("delete from contract").append(source).append("_c where contract_id in (").append(inStr).append(");");
			
			return sBuf.toString().split(";");
		}

		@Override
		public List<Contract> findPage(Page page) {
			return contractHisDao.findPage(page);
		}

		@Override
		public List<Contract> find(Map paraMap) {
			return contractHisDao.find(paraMap);
		}
		
		@Override
		public ContractVO view(String contractId) {
			return contractHisDao.view(contractId);
		}


		@Override
		public void deleteById(Serializable id) {
			Serializable[] ids = {id};
			extCproductHisDao.deleteByContractHisId(ids);                // 删除当前合同下的附件信息
			contractProductHisDao.deleteByContractHisId(ids);            // 删除当前合同下的货物信息
			contractHisDao.deleteById(id);
		}

		@Override
		public void delete(Serializable[] ids) {
			extCproductHisDao.deleteByContractHisId(ids);               // 删除当前合同下的附件信息
			contractProductHisDao.deleteByContractHisId(ids);           // 删除当前合同下的货物信息
			contractHisDao.delete(ids);
			
		}

		

	

}
