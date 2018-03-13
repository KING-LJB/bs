package com.hncj.bs.controller.basicinfo.factory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hncj.bs.controller.BaseController;
import com.hncj.bs.domain.Factory;
import com.hncj.bs.service.FactoryService;

@Controller
public class FactoryController extends BaseController {

	@Resource
	FactoryService factoryService;
	
	// 列表
	@RequestMapping("/basicinfo/factory/list.action")
	public String list(Model model){
		List<Factory> dataList = factoryService.find(null);
		model.addAttribute("dataList", dataList);        // 将数据传递到页面
		
		return "/basicinfo/factory/jFactoryList.jsp";    // 转向页面
	}
	
	// 转向新增页面
    @RequestMapping("basicinfo/factory/tocreate.action")
	public String tocreate(){
		return "/basicinfo/factory/jFactoryCreate.jsp";
	}
	// 新增保存
    @RequestMapping("basicinfo/factory/insert.action")
    public String insert(Factory factory){
    	factoryService.insert(factory);
    	
    	return "redirect:/basicinfo/factory/list.action"; // 转向列表的action
    }	
    
    // 转向更新页面
    @RequestMapping("basicinfo/factory/toupdate.action")
    public String toupdate(String id, Model model){
    	Factory obj = factoryService.get(id);
    	model.addAttribute("obj", obj);
    	
    	return "/basicinfo/factory/jFactoryUpdate.jsp";
    }
    
    // 更新保存
    @RequestMapping("basicinfo/factory/update.action")
    public String update(Factory factory){
    	factoryService.update(factory);
    	
    	return "redirect:/basicinfo/factory/list.action";
    }
    
    // 删除一条数据
    @RequestMapping("basicinfo/factory/deleteById.action")
    public String deleteById(String id){
    	factoryService.deleteById(id);
    	
    	return "redirect:/basicinfo/factory/list.action";
    }
    
    // 删除多条数据
    @RequestMapping("basicinfo/factory/delete.action")
    public String delete(@RequestParam("id") String[] ids){  // 页面上参数名是id，但是封装的时候把它封装到ids数组中
    	factoryService.delete(ids);
    	
    	return "redirect:/basicinfo/factory/list.action";
    }
    
    // 查看
    @RequestMapping("basicinfo/factory/toview.action")
    public String  toview(String id,Model model){
    	Factory obj = factoryService.get(id);
    	model.addAttribute("obj", obj);
    	
    	return "/basicinfo/factory/jFactoryView.jsp";
    }
    
    // 批量的启用
    @RequestMapping("basicinfo/factory/start.action")
    public String start(@RequestParam("id") String[] ids){
    	factoryService.start(ids);
    	
    	return "redirect:/basicinfo/factory/list.action";
    }
    
    // 批量的停用
    @RequestMapping("basicinfo/factory/stop.action")
    public String stop(@RequestParam("id") String[] ids){
    	factoryService.stop(ids);
    	
    	return "redirect:/basicinfo/factory/list.action";
    }
}