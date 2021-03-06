package com.hncj.bs.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.hncj.bs.domain.User;


public interface UserService {
	public User getByUsername(String username);
	public List<User> find(Map paraMap);		        //带条件查询，条件可以为null，既没有条件；返回list对象集合
	
	public User get(Serializable id);					//只查询一个，常用于修改
	public void insert(User user);					//插入，用实体作为参数
	public void update(User user);					//修改，用实体作为参数
	public void deleteById(Serializable id);		        //按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);			        //批量删除；支持整数型和字符串类型ID
	 
}
