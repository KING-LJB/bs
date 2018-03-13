package com.hncj.bs.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hncj.bs.dao.FactoryDao;
import com.hncj.bs.domain.Factory;
import com.hncj.bs.pagination.Page;
import com.hncj.bs.service.FactoryService;

@Service
public class FactoryServiceImpl implements FactoryService {

//	@Resource , @Autowired 两个都是用于注入的
	@Resource
	FactoryDao factoryDao;
	
	@Override
	public List<Factory> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Factory> find(Map paraMap) {
		return factoryDao.find(paraMap);
	}

	@Override
	public Factory get(Serializable id) {
		return factoryDao.get(id);
	}

	@Override
	public void insert(Factory factory) {
		factory.setId(UUID.randomUUID().toString());  //设置UUID
		factory.setState("1");                        //默认设置为启用状态
		factoryDao.insert(factory);
	}

	@Override
	public void update(Factory factory) {
		factoryDao.update(factory);
	}

	@Override
	public void deleteById(Serializable id) {
		factoryDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		factoryDao.delete(ids);
	}

	@Override
	public void start(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 1);             // 1表示启用
		map.put("ids", ids);
		
		factoryDao.updateState(map);
		
	}

	@Override
	public void stop(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 0);             // 0表示停用
		map.put("ids", ids);
		
		factoryDao.updateState(map);
		
	}

	@Override
	public List<Factory> getFactoryList() {
		Map<String , Object> paraMap = new HashMap<String, Object>();
		paraMap.put("state", 1);       // 1 启用,  表示只查询启用了的厂家
 		
		return factoryDao.find(paraMap);
	}

}
