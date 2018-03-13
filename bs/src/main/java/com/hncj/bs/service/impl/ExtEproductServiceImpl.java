package com.hncj.bs.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hncj.bs.dao.ExtEproductDao;
import com.hncj.bs.domain.ExtEproduct;
import com.hncj.bs.pagination.Page;
import com.hncj.bs.service.ExtEproductService;

@Service
public class ExtEproductServiceImpl implements ExtEproductService {

	@Resource
	ExtEproductDao extEproductDao;
	
	@Override
	public List<ExtEproduct> findPage(Page page) {
		return null;
	}

	@Override
	public List<ExtEproduct> find(Map paraMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExtEproduct get(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ExtEproduct extCproduct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ExtEproduct extCproduct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Serializable id) {
		extEproductDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		extEproductDao.delete(ids);
	}

}
