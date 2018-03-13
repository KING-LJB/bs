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
import com.hncj.bs.domain.Contract;
import com.hncj.bs.domain.Log;
import com.hncj.bs.pagination.Page;
import com.hncj.bs.service.ContractService;
import com.hncj.bs.service.LogService;
import com.hncj.bs.vo.ContractVO;

@Service
public class LogServiceImpl implements LogService {

	
	@Resource
	LogDao logDao;
	
	
	public List<Log> find(Map paraMap) {
		return logDao.find(paraMap);
	}


	public void insert(Log log) {
		log.setId(UUID.randomUUID().toString());
		 logDao.insert(log);
	}

	public void update(Log log) {
		 logDao.update(log);
	}

	public void deleteById(Serializable id) {
		logDao.deleteById(id);
	}


	@Override
	public Log get(Serializable id) {
		return logDao.get(id);
	}

	



}
