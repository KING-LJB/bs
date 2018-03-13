package com.hncj.bs.controller;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hncj.common.session.SessionUtil;
import com.hncj.bs.domain.LoginLog;
import com.hncj.bs.domain.User;
import com.hncj.bs.service.LoginLogService;
import com.hncj.bs.service.UserService;
import com.hncj.util.UtilFuns;

@Controller
public class LoginController {
	@Resource
	UserService userService;
	
	@Resource
	LoginLogService loginLogService;
	
	@RequestMapping("/login.action")
	public String login(HttpServletRequest request, String username, String password){
		String returnUrl = "redirect:/logout.action";
		
		if(UtilFuns.isNotEmpty(username)){
			User authUser = userService.getByUsername(username);
			
			if(UtilFuns.isNotEmpty(authUser)){
					if(password.equals(authUser.getPassword())){
						SessionUtil.setCurUser(request, authUser);			//设置当前登录用户
			System.out.println("=============>aaaaaaaa");
			System.out.println("==========>"+authUser.getStation());
						if("管理员".equals(authUser.getStation())){
							 returnUrl = "redirect:/fmain.action";
						}else if("总经理".equals(authUser.getStation())){
							returnUrl = "redirect:/fmain.action";
						}else if("销售主管".equals(authUser.getStation())){
							returnUrl = "redirect:/fmain.action";
						}else if("运输主管".equals(authUser.getStation())){
							returnUrl = "redirect:/fmain.action";
						}
						
						// 当登录成功后，向登录日志表中添加登录信息
						LoginLog loginLog = new LoginLog();
						loginLog.setId(UUID.randomUUID().toString());
						loginLog.setLoginname(authUser.getUsername());
						loginLog.setIpaddress("localhost");
						loginLog.setLogintime(new Date());
						
						loginLogService.insert(loginLog);
						
					}else {
						request.getSession().setAttribute("loginFailed", 1);    //用户名或密码错误, 请重新输入
					}
			}else {
				// 当前用户不存在
				request.getSession().setAttribute("loginFailed", 2);     //    用户名不存在, 请重新输入
			}
		}
		
		
		return returnUrl;
		
		//returnUrl = "redirect:/fmain.action";
		//return returnUrl;
	}
	
	@RequestMapping("/logout.action")
	public String logout(HttpServletRequest request){
		SessionUtil.setCurUser(request, null);				//注销用户，重新登录
		return "/sysadmin/login/logout.jsp";
	}

//	@RequestMapping(value = "/submit", method = RequestMethod.POST)
//	public ModelAndView submit(String username, String password) {
//		User user = new User("shiro", "123456");
//		user.setRole(new Role("member"));
//		try {
//			// 如果登陆成功
//			if (user.getName().equals(username) && user.getPassword().equals(password)) {
//				UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user
//						.getPassword().toString());
//				Subject subject = SecurityUtils.getSubject();
//				subject.login(token);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return new ModelAndView("redirect:/member/index.htm");
//	}
}