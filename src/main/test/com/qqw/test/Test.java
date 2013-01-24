package com.qqw.test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lafengmaker.core.entity.SysLog;
import com.lafengmaker.core.entity.UserSchedule;
import com.lafengmaker.core.util.MD5Util;


public class Test {
	public static void main(String[] args) {
//		System.out.println(MD5Util.getMD5Str("1"));
//		System.out.println(MD5Util.getMD5Str("123456"));
//		String s="[{'id':'8','weekforecast':'50.0','description':''},{'id':'9','weekforecast':'50.0','description':''},{'id':'10','weekforecast':'50.0','description':''},{'id':'11','weekforecast':'50.0','description':''},{'id':'12','weekforecast':'50.0','description':''},{'id':'13','weekforecast':'50.0','description':'7'}]";
//		JSONArray array=JSONArray.fromObject(s);
//		if(null!=array&&array.size()>0){
//			for(int i=0;i<array.size(); i++){
//				UserSchedule us=(UserSchedule)JSONObject.toBean(array.getJSONObject(i), UserSchedule.class);
//				System.out.println(us.getId());
//				System.out.println(us.getDescription());
//				System.out.println(us.getWeekforecast());
//			}
//			ApplicationContext ac=null;
//			ac.getBean(arg0, arg1)
//	}
		Calendar c=Calendar.getInstance();
		Calendar c1=Calendar.getInstance();
		c1.set(Calendar.HOUR_OF_DAY, 17);
		System.out.println(c1.before(c));
		
	}
}
