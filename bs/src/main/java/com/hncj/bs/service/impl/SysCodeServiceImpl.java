package com.hncj.bs.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hncj.bs.dao.SysCodeDao;
import com.hncj.bs.domain.SysCode;
import com.hncj.bs.pagination.Page;
import com.hncj.bs.service.SysCodeService;

@Service
public class SysCodeServiceImpl implements SysCodeService {

//	@Resource , @Autowired 两个都是用于注入的
	@Resource
	SysCodeDao sysCodeDao;
	
//	@Override
//	public List<SysCode> findPage(Page page) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<SysCode> find(Map paraMap) {
		return sysCodeDao.find(paraMap);
	}

	

}
