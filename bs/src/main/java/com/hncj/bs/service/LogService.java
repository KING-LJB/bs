package com.hncj.bs.service;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.hncj.bs.domain.Log;

public interface LogService {
	
	public List<Log> find(Map paraMap);          //带条件查询，条件可以为null，既没有条件；返回list对象集合
	public Log get(Serializable id);
	public void insert(Log log);					//插入，用实体作为参数
	public void update(Log log);					//修改，用实体作为参数
	public void deleteById(Serializable id);		        //按id删除，删除一条；支持整数型和字符串类型ID
	 
	
}
