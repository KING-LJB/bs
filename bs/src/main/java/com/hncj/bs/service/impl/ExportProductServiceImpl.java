package com.hncj.bs.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hncj.bs.dao.ExportProductDao;
import com.hncj.bs.dao.ExtEproductDao;
import com.hncj.bs.domain.ExportProduct;
import com.hncj.bs.pagination.Page;
import com.hncj.bs.service.ExportProductService;

public class ExportProductServiceImpl implements ExportProductService {

	@Resource
	ExportProductDao exportProductDao;
	
	@Resource
	ExtEproductDao extEproductDao;
	
	@Override
	public List<ExportProduct> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExportProduct> find(Map paraMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExportProduct get(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ExportProduct exportProduct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ExportProduct exportProduct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Serializable id) {
		Serializable[] ids = {id};
		extEproductDao.deleteByExportProductById(ids);    // 删除当前货物下的所有附件
		exportProductDao.deleteById(id);
		
	}

	@Override
	public void delete(Serializable[] ids) {
		extEproductDao.deleteByExportProductById(ids);    // 删除当前货物下的所有附件
		exportProductDao.delete(ids);
		
	}

}
