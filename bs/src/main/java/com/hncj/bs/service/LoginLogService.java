package com.hncj.bs.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.hncj.bs.domain.LoginLog;

public interface LoginLogService {
	
	public List<LoginLog> find(Map paraMap);          //带条件查询，条件可以为null，既没有条件；返回list对象集合
	public LoginLog get(Serializable id);
	public void insert(LoginLog loginLog);					//插入，用实体作为参数
	public void update(LoginLog loginLog);					//修改，用实体作为参数
	public void deleteById(Serializable id);		        //按id删除，删除一条；支持整数型和字符串类型ID
	 
	
}
