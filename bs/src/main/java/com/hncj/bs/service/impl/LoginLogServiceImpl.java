package com.hncj.bs.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hncj.bs.dao.ContractDao;
import com.hncj.bs.dao.ContractProductDao;
import com.hncj.bs.dao.ExtCproductDao;
import com.hncj.bs.dao.LogDao;
import com.hncj.bs.dao.LoginLogDao;
import com.hncj.bs.domain.Contract;
import com.hncj.bs.domain.Log;
import com.hncj.bs.domain.LoginLog;
import com.hncj.bs.pagination.Page;
import com.hncj.bs.service.ContractService;
import com.hncj.bs.service.LogService;
import com.hncj.bs.service.LoginLogService;
import com.hncj.bs.vo.ContractVO;

@Service
public class LoginLogServiceImpl implements LoginLogService {

	
	@Resource
	LoginLogDao loginLogDao;
	
	
	public List<LoginLog> find(Map paraMap) {
		return loginLogDao.find(paraMap);
	}


	public void insert(LoginLog loginLog) {
		loginLog.setId(UUID.randomUUID().toString());
		 loginLogDao.insert(loginLog);
	}

	public void update(LoginLog loginLog) {
		loginLogDao.update(loginLog);
	}

	public void deleteById(Serializable id) {
		loginLogDao.deleteById(id);
	}


	@Override
	public LoginLog get(Serializable id) {
		return loginLogDao.get(id);
	}

	



}
