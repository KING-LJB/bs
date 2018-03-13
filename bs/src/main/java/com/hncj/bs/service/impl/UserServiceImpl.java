package com.hncj.bs.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hncj.bs.dao.UserDao;
import com.hncj.bs.domain.User;
import com.hncj.bs.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserDao userDao;

	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}

	@Override
	public List<User> find(Map paraMap) {
		return userDao.find(paraMap);
	}

	@Override
	public User get(Serializable id) {
		return userDao.get(id);
	}

	@Override
	public void insert(User user) {
		user.setId(UUID.randomUUID().toString());
		userDao.insert(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void deleteById(Serializable id) {
		userDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		userDao.delete(ids);
	}
}
