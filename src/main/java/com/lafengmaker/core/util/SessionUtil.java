package com.lafengmaker.core.util;

import java.util.Random;

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
	public  static void add(){
		Random r=new Random();
		
		int j=0;
		while (true) {
			int x=r.nextInt(10);
			int y=r.nextInt(10);
			if(x+y<10){
				if(x>0&&y>0){
					if(j<1){
						System.out.print(x+"\t"+ y+"\t");
						j++;
					}else{
						j=0;
						System.out.println(x+"\t"+ y);
						break;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		for(int i=0;i<3000;i++){
			add();
		}
		
	}
}
