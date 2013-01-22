package com.lafengmaker.core.util;

import javax.servlet.http.HttpServletRequest;

import com.lafengmaker.core.entity.User;
import com.lafengmaker.core.exception.UserException;

public class SessionUtil {
	public static User getUserFromRequest(HttpServletRequest request){
		User u=(User)request.getSession().getAttribute("user");
		if(null==u){
			throw new UserException("no user login");
		}
		return u;
	} 
	public static void AddtoSession(HttpServletRequest request,String key,Object o){
		request.getSession().setAttribute(key, o);
	}
}
