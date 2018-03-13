package com.hncj.bs.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hncj.common.session.SessionUtil;

/**
 * @Description: 拦截器实现权限校验，同时实现性能跟踪
 */

public class LoginInteceptor implements HandlerInterceptor  {
	//绑定线程，实现线程安全
	private NamedThreadLocal<Long> timeThreadLocal = new NamedThreadLocal<Long>("nuStartTime");
	private static Logger log = Logger.getLogger(LoginInteceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		long startTime = System.currentTimeMillis();						//开始时间
		timeThreadLocal.set(startTime);							//绑定记录开始时间
		
		//权限过滤
		if(request.getRequestURI().endsWith("/home.action")
			|| request.getRequestURI().endsWith("/login.action")
			|| request.getRequestURI().endsWith("/logout.action")
		){	
			return true;										//不进行校验的链接
		}else{
			if(SessionUtil.getCurUser(request)==null){			//从Session中获取当前登录用户对象
				response.sendRedirect(request.getContextPath()+"/logout.action");  		//没有session，重新登录
			}else{
				return true;
			}
		}
		return false;
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		
		long stopTime = System.currentTimeMillis();						//结束时间
		log.info(String.format("%s execute time %d ms",request.getRequestURI(),stopTime-timeThreadLocal.get()));
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
