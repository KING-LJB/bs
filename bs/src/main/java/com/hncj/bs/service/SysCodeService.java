package com.hncj.bs.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.hncj.bs.domain.SysCode;
import com.hncj.bs.pagination.Page;

public interface SysCodeService {
//	public List<SysCode> findPage(Page page);				//分页查询
	public List<SysCode> find(Map paraMap);				    //带条件查询，条件可以为null，既没有条件；返回list对象集合
	 
	
}
