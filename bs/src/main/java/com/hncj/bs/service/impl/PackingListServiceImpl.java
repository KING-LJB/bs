package com.hncj.bs.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hncj.bs.dao.ExportDao;
import com.hncj.bs.dao.PackingListDao;
import com.hncj.bs.domain.Export;
import com.hncj.bs.domain.PackingList;
import com.hncj.bs.pagination.Page;
import com.hncj.bs.service.PackingListService;
import com.hncj.util.UtilFuns;

@Service
public class PackingListServiceImpl implements PackingListService {

	@Resource
	PackingListDao packingListDao;
	
	@Resource
	ExportDao exportDao;
	
	
	@Override
	public List<PackingList> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PackingList> find(Map paraMap) {
		return packingListDao.find(paraMap);
	}

	@Override
	public PackingList get(Serializable id) {
		return packingListDao.get(id);
	}

	@Override
	public void insert(PackingList packingList) {
		this.spellString(packingList);
		
		packingList.setId(UUID.randomUUID().toString());
		packingList.setState(0);            // 0 草稿  1 已上报
		packingListDao.insert(packingList);
	}

	@Override
	public void update(PackingList packingList) {
		this.spellString(packingList);
		
		packingListDao.update(packingList);
	}

	@Override
	public void deleteById(Serializable id) {
		Serializable[] ids = {id};
		packingListDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		packingListDao.delete(ids);
	}

	@Override
	public void submit(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 1);            // 1 已上报
		map.put("ids", ids);
		
		packingListDao.updateState(map);
	}

	@Override
	public void cancel(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 0);           // 0 草稿
		map.put("ids", ids);
		
		packingListDao.updateState(map);
	}

	// 拼HTML中的div数据
	public String getDivDataCreate(String[] exportIds){
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < exportIds.length; i++) {
			Export export = exportDao.get(exportIds[i]);
			sBuffer.append("<input type=\"checkbox\" checked name=\"exportIds\" value=\"").append(exportIds[i]).append("|")
			       .append(export.getCustomerContract()).append("\" class=\"input\"></input>");
			sBuffer.append(export.getCustomerContract()).append("&nbsp;&nbsp;");  
		}
		return sBuffer.toString();
	}
	
	public String getDivDataView(String[] exportNos){
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < exportNos.length; i++) {
			sBuffer.append(exportNos[i]).append("&nbsp;&nbsp;");  
		}
		return sBuffer.toString();
		
	}
	
	public String getDivDataUpdate(String[] exportIds,String[] exportNos){
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < exportIds.length; i++) {
			Export export = exportDao.get(exportIds[i]);
			sBuffer.append("<input type=\"checkbox\" checked name=\"exportIds\" value=\"").append(exportIds[i]).append("|")
			       .append(exportNos[i]).append("\" class=\"input\"></input>");
			sBuffer.append(exportNos[i]).append("&nbsp;&nbsp;");  
		}
		return sBuffer.toString();
	}

	// 被抽取出来的   拆串、拼串  方法 
	private PackingList spellString(PackingList packingList){
		String _exportNos = "";
		String _exportIds = "";
		
		String[] _s = packingList.getExportIds().split(",");    // 得到的结果是 id|no 的 集合（下面拼写的语句中把两者拼到一起了，用 | 分开的）
		for(int i=0;i<_s.length;i++){
			String[] _temp = _s[i].split("\\|");                //split中是一正则表达式，用 | 进行拆分时，要对 | 进行转义，使用 双斜杠 \\ 转义 
			_exportIds += _temp[0] + "|";                      // 循环中的各项也用 | 进行分割开  
			_exportNos += _temp[1] + "|";
		}                                                      // 最后得到的结果中结尾多了一个    |  符号
		_exportIds = UtilFuns.delLastChar(_exportIds);         // 调用工具类的删除最最后一个字符的方法
		_exportNos =UtilFuns.delLastChar(_exportNos);
		
		packingList.setExportIds(_exportIds);
		packingList.setExportNos(_exportNos);
		
		return packingList;
	}
	
}
