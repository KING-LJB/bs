package com.hncj.bs.controller.basicinfo.log;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hncj.bs.controller.BaseController;
import com.hncj.bs.domain.Log;
import com.hncj.bs.service.LogService;

@Controller
public class LogController extends BaseController{

	@Resource
	LogService logService;
	
	@RequestMapping("/basicinfo/log/list.action")
	public String list(Model model){
		List<Log> dataList = logService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/home/olmsgList.jsp";
	}
	
	@RequestMapping("/basicinfo/log/tocreate.action")
	public String tocreate(){
		
		return "/basicinfo/log/jLogCreate.jsp";
	}
	
	@RequestMapping("/basicinfo/log/insert.action")
	public String insert(Log log){
		logService.insert(log);
		
		
		return "redirect:/basicinfo/log/list.action";
	}
	
	
	@RequestMapping("/basicinfo/log/delete.action")
	public String delete(String id){
		logService.deleteById(id);
		
		return "redirect:/basicinfo/log/list.action";
	}
	
	@RequestMapping("/basicinfo/log/toedit.action")
	public String toedit(String id,Model model){
		Log obj = logService.get(id);
		model.addAttribute("obj", obj);
		
		return "/basicinfo/log/jLogUpdate.jsp";
	}
	
	@RequestMapping("/basicinfo/log/update.action")
	public String update(Log log){
		logService.update(log);
		
		return "redirect:/basicinfo/log/list.action";
	}
	
}
