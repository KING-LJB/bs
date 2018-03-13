package com.hncj.bs.dao.impl;

import org.springframework.stereotype.Repository;

import com.hncj.bs.dao.OutProductDao;
import com.hncj.bs.vo.OutProductVO;

@Repository //不加注解，无法扫描到该dao
public class OutProductDaoImpl extends BaseDaoImpl<OutProductVO> implements OutProductDao{

	public OutProductDaoImpl() {
		//设置命名空间
		super.setNs("com.hncj.bs.mapper.OutProductMapper");
	}



	
}
