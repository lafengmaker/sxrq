package com.lafengmaker.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lafengmaker.core.service.ScheduleService;

@Component(value="jobManage")
public class JobManage {
	private ScheduleService scheduleService;
	public void iniWeekData(){
		this.scheduleService.insertWeekData();
	}
	public ScheduleService getScheduleService() {
		return scheduleService;
	}
	@Autowired
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	
}
