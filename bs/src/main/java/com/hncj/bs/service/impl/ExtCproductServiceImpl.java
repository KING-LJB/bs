package com.hncj.bs.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hncj.bs.dao.ExtCproductDao;
import com.hncj.bs.dao.SysCodeDao;
import com.hncj.bs.domain.ExtCproduct;
import com.hncj.bs.domain.SysCode;
import com.hncj.bs.pagination.Page;
import com.hncj.bs.service.ExtCproductService;
import com.hncj.util.UtilFuns;

@Service
public class ExtCproductServiceImpl implements ExtCproductService {

	@Resource
	ExtCproductDao extCproductDao;
	
	@Resource
	SysCodeDao sysCodeDao;
	
	@Override
	public List<ExtCproduct> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExtCproduct> find(Map paraMap) {
		return extCproductDao.find(paraMap);
	}

	@Override
	public ExtCproduct get(Serializable id) {
		return extCproductDao.get(id);
	}

	@Override
	public void insert(ExtCproduct extCproduct) {
		extCproduct.setId(UUID.randomUUID().toString());
		// 自动计算总金额=数量*单价                                     ...修改，删除；同步合同总金额
		if(UtilFuns.isNotEmpty(extCproduct.getCnumber()) && UtilFuns.isNotEmpty(extCproduct.getPrice())){
		extCproduct.setAmount(extCproduct.getCnumber() * extCproduct.getPrice());
		}
		
		extCproductDao.insert(extCproduct);
	}

	@Override
	public void update(ExtCproduct extCproduct) {
		extCproductDao.update(extCproduct);
	}

	@Override
	public void deleteById(Serializable id) {
		extCproductDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		extCproductDao.delete(ids);
	}

	@Override
	public List<SysCode> getCtypeList() {
		Map paraMap = new HashMap();
		paraMap.put("parentId", "0104");          // sys_code_b 0104附件分类
		
		return sysCodeDao.find(paraMap);
	}


}
