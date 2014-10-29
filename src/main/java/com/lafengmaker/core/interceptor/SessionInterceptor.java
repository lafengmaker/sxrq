package com.lafengmaker.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lafengmaker.core.entity.User;
import com.lafengmaker.core.util.SessionUtil;

public class SessionInterceptor implements HandlerInterceptor {
	private static Logger logger=Logger.getLogger(SessionInterceptor.class);
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		try {
			User u=SessionUtil.getUserFromRequest(request);
			logger.debug("userid:"+u.getId());
			return true;
		} catch (Exception e) {
			logger.error("拦截器出错",e);
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
			
		}
	}
	
}
