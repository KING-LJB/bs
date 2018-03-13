package com.hncj.bs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	//系统首页模块
	
	@RequestMapping(value={"/home.action"})		//配合web下<url-pattern>/</url-pattern>
	public String login(){
		
		return "/sysadmin/login/login.jsp";			//首页，删除根目录下index.jsp，否则上面url将被拦截进不来
	}
	
	@RequestMapping(value="/fmain.action")
	public String fmain(){
		return "/home/fmain.jsp";
	}
	
	@RequestMapping(value="/title.action")
	public String title(){
		return "/home/title.jsp";
	}
	
	@RequestMapping(value="/left.action")
	public String left(){
		return "/home/left.jsp";
	}
	
	@RequestMapping(value="/main.action")
	public String main(){
		return "/home/olmsgList.jsp";			//首页转向留言板
	}
	
	//系统管理模块
	
	@RequestMapping("/sysadminMain.action")
	public String sysadminMain(){
		return "/sysadmin/main.jsp";
	}
	
	@RequestMapping("/sysadminLeft.action")
	public String sysadminLeft(){
		return "/sysadmin/left.jsp";
	}
	
	//基础信息模块
	
	@RequestMapping("/baseinfoMain.action")
	public String baseinfoMain(){
		return "/baseinfo/main.jsp";
	}
	
	@RequestMapping("/baseinfoLeft.action")
	public String baseinfoLeft(){
		return "/baseinfo/left.jsp";
	}
	
	// 统计分析模块
	@RequestMapping("/statMain.action")
	public String statMain(){
		return "/stat/main.jsp";
	}
	
	@RequestMapping("/statLeft.action")
	public String statLeft(){
		return "/stat/left.jsp";
	}
	
	//货运管理模块
	
	@RequestMapping("/cargoMain.action")
	public String cargoMain(){
		return "/cargo/main.jsp";
	}
	
	@RequestMapping("/cargoLeft1.action")
	public String cargoLeft(){
		return "/cargo/left1.jsp";
	}
	
	@RequestMapping("/cargoLeft2.action")
	public String cargoLeft2(){
		return "/cargo/left2.jsp";
	}
	
	@RequestMapping("/cargoLeft3.action")
	public String cargoLeft3(){
		return "/cargo/left3.jsp";
	}
}
