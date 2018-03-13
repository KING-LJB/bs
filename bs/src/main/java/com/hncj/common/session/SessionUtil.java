package com.hncj.common.session;

import javax.servlet.http.HttpServletRequest;

import com.hncj.bs.domain.User;

/**
 * @Description: 用户session工具类
 */

public class SessionUtil {
	public static final String GLOBLE_USER_SESSION = "NU_CURRENT_USER";
	
	//设置当前登录用户或者注销
	public static void setCurUser(HttpServletRequest request, User user){
		if(user!=null){
			request.getSession().setAttribute(GLOBLE_USER_SESSION, user);
		}else{
			request.getSession().removeAttribute(GLOBLE_USER_SESSION);
		}
	}
	
	//获取当前登录用户
	public static User getCurUser(HttpServletRequest request){
		return (User) request.getSession().getAttribute(GLOBLE_USER_SESSION);
	}
}
