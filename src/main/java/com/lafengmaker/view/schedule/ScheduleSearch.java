package com.lafengmaker.view.schedule;

import com.lafengmaker.core.util.StringUtil;

public class ScheduleSearch {
	private Long  userid;
	private String  date;
	private String enddate;
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getDate() {
		if(StringUtil.isEmpty(date)){
			return null;
		}
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEnddate() {
		if(StringUtil.isEmpty(enddate)){
			return null;
		}
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
	
}
