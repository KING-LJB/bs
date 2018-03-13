package com.hncj.bs.dao.impl;

import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.UserDao;
import com.hncj.bs.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	public UserDaoImpl() {
		super.setNs("com.hncj.bs.mapper.UserMapper");
	}

	public User getByUsername(String username) {
		return this.getSqlSession().selectOne(this.getNs()+".getByUsername", username);
	}
}
