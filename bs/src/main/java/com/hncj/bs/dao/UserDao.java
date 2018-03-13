package com.hncj.bs.dao;

import com.hncj.bs.domain.User;



public interface UserDao extends BaseDao<User>{
	public User getByUsername(String username);
}
