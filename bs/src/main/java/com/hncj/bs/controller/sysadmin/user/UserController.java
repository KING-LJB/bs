package com.hncj.bs.controller.sysadmin.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hncj.bs.controller.BaseController;
import com.hncj.bs.domain.User;
import com.hncj.bs.service.UserService;

/**
 * 系统管理模块
 * @author Administrator
 *
 */
@Controller
public class UserController extends BaseController {
	
	@Resource
	UserService userService;
	
	@RequestMapping("/sysadmin/user/list.action")
	public String list(Model model ){
		List<User> dataList = userService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/sysadmin/user/jUserList.jsp";
	}
	
	@RequestMapping("/sysadmin/user/tocreate.action")
	public String tocreate(){
		
		return "/sysadmin/user/jUserCreate.jsp";
	}
	
	@RequestMapping("/sysadmin/user/insert.action")
	public String insert(User user){
		userService.insert(user);
		return "redirect:/sysadmin/user/list.action";
	}
	
	@RequestMapping("/sysadmin/user/toupdate.action")
	public String toupdate(String id,Model model){
		User obj = userService.get(id);
		model.addAttribute("obj", obj);
		
		return "/sysadmin/user/jUserUpdate.jsp";
	}
	
	@RequestMapping("/sysadmin/user/update.action")
	public String update(User user){
		userService.update(user);
		
		return "redirect:/sysadmin/user/list.action";
	}
	
	@RequestMapping("/sysadmin/user/delete.action")
	public String delete(@RequestParam("id") String[] ids){
		userService.delete(ids);
		
		return "redirect:/sysadmin/user/list.action";
	}
	

}
