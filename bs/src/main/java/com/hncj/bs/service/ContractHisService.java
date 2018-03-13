package com.hncj.bs.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.hncj.bs.domain.Contract;
import com.hncj.bs.pagination.Page;
import com.hncj.bs.vo.ContractVO;


/**
 * 历史合同：从合同表中分离出来的不常用的合同信息（分表操作时用的）
 * @author Administrator
 *
 */
public interface ContractHisService {
	public List<Contract> findPage(Page page);				//分页查询
	public List<Contract> find(Map paraMap);				    //带条件查询，条件可以为null，既没有条件；返回list对象集合
	public void deleteById(Serializable id);		        //按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);			        //批量删除；支持整数型和字符串类型ID
	public ContractVO view(String contractId);              //关联对象查询一个   
	
	public void pigeinhole(String[] contractIds);         // 归档
	public void pigeouthole(String[] contractIds);        // 取消归档

}
