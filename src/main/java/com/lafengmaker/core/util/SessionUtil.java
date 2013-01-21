package com.lafengmaker.core.util;

import javax.servlet.http.HttpServletRequest;

import com.lafengmaker.core.entity.User;

public class SessionUtil {
	public static User getUserFromRequest(HttpServletRequest request){
		User u=(User)request.getSession().getAttribute("user");
		if(null==u){
			u=new User();
		}
		return u;
	} 
}
